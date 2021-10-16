package br.com.scc4.tms.controller.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDestino;
import br.com.scc4.tms.repository.tenant.EmbarcadorDestinoRepository;
import br.com.scc4.tms.service.tenant.EmbarcadorDestinoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/embarcadordestino")
public class EmbarcadorDestinoController {

    @Autowired
    private EmbarcadorDestinoServiceImpl embarcadorDestinoServiceImpl;

    @Autowired
    private EmbarcadorDestinoRepository embarcadorDestinoRepository;


    @GetMapping
    public List verTodosEmbarcadorDestino() {
        return embarcadorDestinoRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmbarcadorDestino> buscarPeloCodigo(@PathVariable Long id) {
        Optional<EmbarcadorDestino> embarcadorDestinoOptional = embarcadorDestinoRepository.findById(id);

        return embarcadorDestinoOptional.isPresent() ? ResponseEntity.ok(embarcadorDestinoOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmbarcadorDestino salvar(@Valid @RequestBody EmbarcadorDestino embarcadorDestino) {
        return embarcadorDestinoServiceImpl.salvar(embarcadorDestino);
    }

    @PutMapping("/{id}")
    public EmbarcadorDestino atualizar(@PathVariable Long id, @Valid @RequestBody EmbarcadorDestino embarcadorDestino) {
        embarcadorDestino.setId(id);
        return embarcadorDestinoServiceImpl.salvar(embarcadorDestino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        embarcadorDestinoServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
