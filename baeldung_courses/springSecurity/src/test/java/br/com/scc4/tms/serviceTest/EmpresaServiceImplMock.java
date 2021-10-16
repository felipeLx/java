package br.com.scc4.tms.serviceTest;

import br.com.scc4.tms.model.main.Empresa;
import br.com.scc4.tms.model.main.Plataforma;
import br.com.scc4.tms.repository.main.EmpresaRepository;
import br.com.scc4.tms.repository.main.PlataformaRepository;
import br.com.scc4.tms.repository.main.UsuarioRepository;
import br.com.scc4.tms.service.main.EmpresaServiceImpl;
import br.com.scc4.tms.service.main.exception.RegistroJaExisteException;
import br.com.scc4.tms.service.main.exception.RegistroNaoEncontradoException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class EmpresaServiceImplMock {

    private EmpresaServiceImpl empresaServiceImpl;

    @Mock
    private EmpresaRepository empresaRepositoryMocked;

    @Mock
    private PlataformaRepository plataformaRepositoryMock;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        empresaServiceImpl = new EmpresaServiceImpl(empresaRepositoryMocked, plataformaRepositoryMock, usuarioRepository);
    }

    @Test(expected = RegistroJaExisteException.class)
    public void canNotCreateBusinessThatExist() {
        Empresa empresaTest = getEmpresaDaBd();

        when(empresaRepositoryMocked.findById(1L)).thenReturn((Optional.of(empresaTest)));
    }

    @Test(expected = RegistroNaoEncontradoException.class)
    public void canNotDeleteBusinessThatExist() {
        Empresa empresaTest = getEmpresaDaBd();

        when(empresaRepositoryMocked.findById(1L)).thenReturn((Optional.of(empresaTest)));
    }

    private Empresa getEmpresaDaBd() {
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setCnpj("11.118.130.245-90");
        empresa.setNomeEmpresa("Servicos e Produtos de logística");
        empresa.setNomeFantasia("SPLogística");
        empresa.setEndereco("Rua da Cruz, 22");
        empresa.setTelefone("9912-488923");
        empresa.setBairro("Cacupe");
        empresa.setCidade("Caruipe");
        empresa.setUf("SC");
        empresa.setComplemento("");
        empresa.setEmail("rui@gmail.com");
        empresa.setPlataforma(new Plataforma());
        empresa.setStatus(true);
        empresa.setDataHora(LocalDate.now());

        return empresa;
    }
}

