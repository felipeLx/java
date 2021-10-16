package br.com.scc4.tms.service.main;

import br.com.scc4.tms.model.main.Usuario;
import br.com.scc4.tms.repository.main.UsuarioRepository;
import br.com.scc4.tms.service.main.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Optional findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public Object salvar(Object variable) {
        validarCpf((Usuario) variable);
        return usuarioRepository.saveAndFlush((Usuario) variable);
    }

    @Transactional
    public void apagar(Long id) {
        verificarSeUsuarioExiste(id);
        usuarioRepository.deleteById(id);
    }

    private void validarCpf(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuarioOptional.isPresent() && usuario.isNew() ||
                usuarioOptional.isPresent() && !usuario.getCpf().equalsIgnoreCase(usuarioOptional.get().getCpf())) {
            throw new RegistroJaExisteException("generic-3");
        }
    }

    public boolean verificarSeUsuarioExiste(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (!usuarioOptional.isPresent()) {
            throw new RegistroNaoEncontradoException("generic-2");
        }
        return true;
    }


    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with -> username or email : " + username));
        return UserPrinciple.build(usuario);
    }
}