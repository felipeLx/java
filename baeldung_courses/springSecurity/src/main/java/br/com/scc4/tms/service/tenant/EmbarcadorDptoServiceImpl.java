package br.com.scc4.tms.service.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDpto;
import br.com.scc4.tms.repository.tenant.EmbarcadorDptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmbarcadorDptoServiceImpl implements IEmbarcadorService {

    private EmbarcadorDptoRepository embarcadorDptoRepository;

    public EmbarcadorDptoServiceImpl(@Autowired EmbarcadorDptoRepository embarcadorDptoRepository) {
        this.embarcadorDptoRepository = embarcadorDptoRepository;
    }

    @Transactional
    @Override
    public Optional<EmbarcadorDpto> findById(Long id) {
        return embarcadorDptoRepository.findById(id);
    }

    @Transactional
    public EmbarcadorDpto salvar(EmbarcadorDpto embarcadorDpto) {
        return embarcadorDptoRepository.save(embarcadorDpto);
    }

    @Transactional
    @Override
    public void apagar(Long id) {
        embarcadorDptoRepository.deleteById(id);
    }
}
