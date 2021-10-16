package br.com.scc4.tms.service.tenant;

import br.com.scc4.tms.model.tenant.Embarcador;
import br.com.scc4.tms.repository.tenant.EmbarcadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmbarcadorServiceImpl implements IEmbarcadorService{

    private EmbarcadorRepository embarcadorRepository;

    public EmbarcadorServiceImpl(@Autowired EmbarcadorRepository embarcadorRepository) {
        this.embarcadorRepository = embarcadorRepository;
    }

    @Transactional
    @Override
    public void apagar(Long id) {
        embarcadorRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<Embarcador> findById(Long id) {
        return embarcadorRepository.findById(id);
    }

    @Transactional
    public Embarcador salvar(Embarcador embarcador) {
        return embarcadorRepository.save(embarcador);
    }
}
