package br.com.scc4.tms.service.main;

import br.com.scc4.tms.model.main.Empresa;
import br.com.scc4.tms.model.main.Plataforma;
import br.com.scc4.tms.repository.main.EmpresaRepository;

import br.com.scc4.tms.repository.main.PlataformaRepository;
import br.com.scc4.tms.repository.main.UsuarioRepository;
import br.com.scc4.tms.service.main.exception.RegistroJaExisteException;
import br.com.scc4.tms.service.main.exception.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpresaServiceImpl {


    private UsuarioRepository usuarioRepository;
    private EmpresaRepository empresaRepository;
    private PlataformaRepository plataformaRepository;

    public EmpresaServiceImpl(
            @Autowired EmpresaRepository empresaRepository,
            @Autowired PlataformaRepository plataformaRepository,
            @Autowired UsuarioRepository usuarioRepository
            ) {

        this.empresaRepository = empresaRepository;
        this.plataformaRepository = plataformaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public Optional findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Transactional
    public Empresa salvar(Object variable) {
        validarCnpj((Empresa) variable);
        validarPlatafor(((Empresa) variable).getPlataforma());
        return empresaRepository.saveAndFlush((Empresa) variable);
    }

    @Transactional
    public void apagar(Long idEmpresa) {
//        verificarSeEmpresaTemUsuario(idEmpresa);
        verificarSeEmpresaExiste(idEmpresa);
        empresaRepository.deleteById(idEmpresa);
    }

    private void verificarSeEmpresaExiste(Long id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if(!optionalEmpresa.isPresent()) {
            throw new RegistroNaoEncontradoException("generic-2");
        }
    }

//    private void verificarSeEmpresaTemUsuario(Long empresaId) {
//        Optional<Usuario> optionalUsuario = usuarioRepository.findFirst1ByEmpresaId(empresaId);
//        if (optionalUsuario.isPresent()) {
//            throw new RegistroJaExisteException("generic-5");
//        }
//    }

    private void validarPlatafor(Plataforma plataforma) {
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(plataforma.getId());
        if(!plataformaOptional.isPresent()) {
            throw new RegistroNaoEncontradoException("plataformas-99");
        }
    }

    private void validarCnpj(Empresa empresa) {
        Optional<Empresa> empresaOptional = empresaRepository.findByCnpj(empresa.getCnpj());
        if (empresaOptional.isPresent() && empresa.isNew() ||
                empresaOptional.isPresent() && !empresa.getCnpj().equalsIgnoreCase(empresaOptional.get().getCnpj())) {
            throw new RegistroJaExisteException("generic-3");
        }
    }
}
