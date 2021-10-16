package br.com.scc4.tms.service.main;

import br.com.scc4.tms.model.main.Transportadora;
import br.com.scc4.tms.repository.main.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransportadoraServiceImpl {

    private TransportadoraRepository transportadoraRepository;

    public TransportadoraServiceImpl(@Autowired TransportadoraRepository transportadoraRepository) {
        this.transportadoraRepository = transportadoraRepository;
    }

    @Transactional
    public Optional findById(Long id) {
        return transportadoraRepository.findById(id);
    }

    @Transactional
    public Transportadora salvar(Object variable) {
        return transportadoraRepository.saveAndFlush((Transportadora) variable);
    }

    @Transactional
    public void apagar(Long id) {
        transportadoraRepository.deleteById(id);
    }
}
