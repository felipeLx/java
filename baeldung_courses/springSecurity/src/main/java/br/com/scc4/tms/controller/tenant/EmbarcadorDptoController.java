package br.com.scc4.tms.controller.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDpto;
import br.com.scc4.tms.repository.tenant.EmbarcadorDptoRepository;
import br.com.scc4.tms.service.tenant.EmbarcadorDptoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/embarcadordpto")
public class EmbarcadorDptoController {

    private EmbarcadorDptoServiceImpl embarcadorDptoServiceImpl;

    private EmbarcadorDptoRepository embarcadorDptoRepository;

    public EmbarcadorDptoController(@Autowired EmbarcadorDptoServiceImpl embarcadorDptoServiceImpl, @Autowired EmbarcadorDptoRepository embarcadorDptoRepository) {
        this.embarcadorDptoServiceImpl = embarcadorDptoServiceImpl;
        this.embarcadorDptoRepository = embarcadorDptoRepository;
    }

    @GetMapping
    public List<EmbarcadorDpto> verTodosEmbarcadorDpto() {
        return embarcadorDptoRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmbarcadorDpto> buscarPeloCodigo(@PathVariable Long id) {
        Optional<EmbarcadorDpto> empresaOptional = embarcadorDptoRepository.findById(id);

        return empresaOptional.isPresent() ? ResponseEntity.ok(empresaOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmbarcadorDpto salvar(@Valid @RequestBody EmbarcadorDpto embarcadorDpto) {
        return embarcadorDptoServiceImpl.salvar(embarcadorDpto);
    }

    @PutMapping("/{id}")
    public EmbarcadorDpto atualizar(@PathVariable Long id, @Valid @RequestBody EmbarcadorDpto  embarcadorDpto) {
        embarcadorDptoRepository.findById(id);
        return embarcadorDptoServiceImpl.salvar(embarcadorDpto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        embarcadorDptoServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
