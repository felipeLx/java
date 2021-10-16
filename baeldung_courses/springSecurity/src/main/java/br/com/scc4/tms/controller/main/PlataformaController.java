package br.com.scc4.tms.controller.main;

import br.com.scc4.tms.model.main.Plataforma;
import br.com.scc4.tms.repository.main.PlataformaRepository;
import br.com.scc4.tms.service.main.PlataformaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaServiceImpl plataformaServiceImpl;

    @Autowired
    private PlataformaRepository plataformaRepository;

    @GetMapping
    public List verTodasPlataformas() {
        return plataformaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plataforma> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(id);

        return plataformaOptional.isPresent() ? ResponseEntity.ok(plataformaOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Plataforma salvar(@Valid @RequestBody Plataforma plataforma) {
        return plataformaServiceImpl.salvar(plataforma);
    }

    @PutMapping("/{id}")
    public Plataforma atualizar(@PathVariable Long id, @Valid @RequestBody Plataforma plataforma) {
        plataforma.setId(id);
        return plataformaServiceImpl.salvar(plataforma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        plataformaServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
