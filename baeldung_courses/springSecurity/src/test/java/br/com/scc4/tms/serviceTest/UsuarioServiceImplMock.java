package br.com.scc4.tms.serviceTest;

import br.com.scc4.tms.model.main.Usuario;
import br.com.scc4.tms.repository.main.EmpresaRepository;
import br.com.scc4.tms.repository.main.UsuarioRepository;
import br.com.scc4.tms.service.main.UsuarioServiceImpl;
import br.com.scc4.tms.service.main.exception.RegistroJaExisteException;
import br.com.scc4.tms.service.main.exception.RegistroNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class UsuarioServiceImplMock {

    private UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    private UsuarioRepository usuarioRepositoryMocked;

    @Mock
    private EmpresaRepository empresaRepositoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        usuarioServiceImpl = new UsuarioServiceImpl(usuarioRepositoryMocked);
    }

    @Test(expected = RegistroJaExisteException.class)
    public void canNotCreateUserThatExist() {
        Usuario usuarioTest = getUsuarioDaBd();

        when(usuarioRepositoryMocked.findById(1L)).thenReturn((Optional.of(usuarioTest)));
    }

    @Test(expected = RegistroNaoEncontradoException.class)
    public void canNotDeleteUserThatExist() {
        Usuario usuarioTest = getUsuarioDaBd();

        when(usuarioRepositoryMocked.findById(1L)).thenReturn((Optional.of(usuarioTest)));
    }


    private Usuario getUsuarioDaBd() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCpf("112.118.130-90");
        usuario.setNome("Rui Barros");
        usuario.setEmail("rui@gmail.com");
        usuario.setSenha("123teste123testando");
        usuario.setStatus(true);
        usuario.setDataExpiracao(LocalDate.parse("18/10/2020"));

        return usuario;
    }

}
