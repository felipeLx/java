package br.com.scc4.tms.controller.main;


import br.com.scc4.tms.model.main.Usuario;
import br.com.scc4.tms.repository.main.UsuarioRepository;
import br.com.scc4.tms.service.main.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List verTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        return usuarioOptional.isPresent() ? ResponseEntity.ok(usuarioOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@Valid @RequestBody Usuario usuario) {
        return (Usuario) usuarioServiceImpl.salvar(usuario);
    }


    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        return (Usuario) usuarioServiceImpl.salvar(usuario);
    }


    // remove business by Id
    @DeleteMapping("/{id}")
    public ResponseEntity apagarDados(@PathVariable Long id) {
        usuarioServiceImpl.apagar(id);
        return ResponseEntity.noContent().build();
    }
}


