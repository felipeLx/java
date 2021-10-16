package br.com.scc4.tms.controller.main;

import br.com.scc4.tms.model.main.Transportadora;
import br.com.scc4.tms.repository.main.TransportadoraRepository;
import br.com.scc4.tms.service.main.TransportadoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transportadoras")
public class TransportadoraController {

    @Autowired
    private TransportadoraServiceImpl transportadoraServiceImpl;

    @Autowired
    private TransportadoraRepository transportadoraRepository;


    @GetMapping
    public List verTodosRoles() {
        return transportadoraRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transportadora> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Transportadora> roleOptional = transportadoraRepository.findById(id);

        return roleOptional.isPresent() ? ResponseEntity.ok(roleOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transportadora salvar(@Valid @RequestBody Transportadora transportadora) {
        return transportadoraServiceImpl.salvar(transportadora);
    }

    @PutMapping("/{id}")
    public Transportadora atualizar(@PathVariable Long id, @Valid @RequestBody Transportadora transportadora) {
        transportadora.setId(id);
        return transportadoraServiceImpl.salvar(transportadora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        transportadoraServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
