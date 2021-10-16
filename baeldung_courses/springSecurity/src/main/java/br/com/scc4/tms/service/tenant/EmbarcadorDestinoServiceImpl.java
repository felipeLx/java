package br.com.scc4.tms.service.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDestino;
import br.com.scc4.tms.repository.tenant.EmbarcadorDestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmbarcadorDestinoServiceImpl implements IEmbarcadorService {

    private EmbarcadorDestinoRepository embarcadorDestinoRepository;

    public EmbarcadorDestinoServiceImpl(@Autowired EmbarcadorDestinoRepository embarcadorDestinoRepository) {
        this.embarcadorDestinoRepository = embarcadorDestinoRepository;
    }

    @Transactional
    @Override
    public Optional<EmbarcadorDestino> findById(Long id) {
        return embarcadorDestinoRepository.findById(id);
    }

    @Transactional
    public EmbarcadorDestino salvar(EmbarcadorDestino embarcadorDestino) {
        return embarcadorDestinoRepository.save(embarcadorDestino);
    }

    @Transactional
    @Override
    public void apagar(Long id) {
        embarcadorDestinoRepository.deleteById(id);
    }
}
