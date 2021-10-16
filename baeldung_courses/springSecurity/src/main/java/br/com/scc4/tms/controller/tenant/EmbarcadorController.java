package br.com.scc4.tms.controller.tenant;

import br.com.scc4.tms.model.tenant.Embarcador;
import br.com.scc4.tms.repository.tenant.EmbarcadorRepository;
import br.com.scc4.tms.service.tenant.EmbarcadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/embarcador")
public class EmbarcadorController {


    private EmbarcadorServiceImpl embarcadorServiceImpl;

    private EmbarcadorRepository embarcadorRepository;

    public EmbarcadorController(@Autowired EmbarcadorServiceImpl embarcadorServiceImpl, @Autowired EmbarcadorRepository embarcadorRepository) {
        this.embarcadorServiceImpl = embarcadorServiceImpl;
        this.embarcadorRepository = embarcadorRepository;
    }


    @GetMapping
    public List verTodasEmpresas() {
        return embarcadorRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Embarcador> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Embarcador> empresaOptional = embarcadorRepository.findById(id);

        return empresaOptional.isPresent() ? ResponseEntity.ok(empresaOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Embarcador salvar(@Valid @RequestBody Embarcador embarcador) {
        return embarcadorServiceImpl.salvar(embarcador);
    }

    @PutMapping("/{id}")
    public Embarcador atualizar(@PathVariable Long id, @Valid @RequestBody Embarcador embarcador) {
        embarcador.setId(id);
        return embarcadorServiceImpl.salvar(embarcador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        embarcadorServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
