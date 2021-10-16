package br.com.scc4.tms.controller.main;

import br.com.scc4.tms.model.main.Empresa;
import br.com.scc4.tms.repository.main.EmpresaRepository;
import br.com.scc4.tms.service.main.EmpresaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl empresaServiceImpl;

    @Autowired
    private EmpresaRepository empresaRepository;


    @GetMapping
    public List verTodasEmpresas() {
        return empresaRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findFirst1ByPlataformaId(id);

        return empresaOptional.isPresent() ? ResponseEntity.ok(empresaOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa salvar(@Valid @RequestBody Empresa empresa) {
        return empresaServiceImpl.salvar(empresa);
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        empresa.setId(id);
        return empresaServiceImpl.salvar(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        empresaServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
