package br.com.scc4.tms.service.main;

import br.com.scc4.tms.model.main.Empresa;
import br.com.scc4.tms.model.main.Plataforma;
import br.com.scc4.tms.repository.main.EmpresaRepository;
import br.com.scc4.tms.repository.main.PlataformaRepository;
import br.com.scc4.tms.service.main.exception.RegistroNaoEncontradoException;
import br.com.scc4.tms.service.main.exception.RegistroNaoEstaVazioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class PlataformaServiceImpl {

    private PlataformaRepository plataformaRepository;
    private EmpresaRepository empresaRepository;

    public PlataformaServiceImpl(@Autowired PlataformaRepository plataformaRepository, @Autowired EmpresaRepository empresaRepository) {
        this.plataformaRepository = plataformaRepository;
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public Plataforma salvar(Plataforma plataforma) {
        Optional<Plataforma> plataformaOptional = plataformaRepository.findByNomePlataforma(plataforma.getNomePlataforma());
        if ((plataformaOptional.isPresent() && plataforma.isNew()) ||
            plataformaOptional.isPresent() && !plataforma.getNomePlataforma().equalsIgnoreCase(plataformaOptional.get().getNomePlataforma())) {

                plataformaRepository.saveAndFlush(plataforma);
        }
        return plataforma;
    }

    @Transactional
    public Optional findById(Long id) {
        return plataformaRepository.findById(id);
    }


    @Transactional
    public void apagar(Long id) {
        verificarSePlataformaExiste(id);
        verificarSeTemEmpresaCadastrada(id);
        plataformaRepository.deleteById(id);
    }



    public void verificarSePlataformaExiste(Long id) {
        Optional<Plataforma> optionalPlataforma = plataformaRepository.findById(id);
        if(!optionalPlataforma.isPresent()) {
            throw new RegistroNaoEncontradoException("generic-2");
        }
    }

    private void verificarSeTemEmpresaCadastrada(Long id) {
        Optional<Empresa> optionalEmpresa = empresaRepository.findFirst1ByPlataformaId(id);
        if (optionalEmpresa.isPresent()) {
            throw new RegistroNaoEstaVazioException("generic-5");
        }
    }
}
