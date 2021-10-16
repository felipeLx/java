package br.com.scc4.tms.repository.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDestino;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public interface EmbarcadorDestinoRepository  extends JpaRepository<EmbarcadorDestino, Long> {

    List<EmbarcadorDestino> embarcadorDestinos = new ArrayList<>();

    Optional<EmbarcadorDestino> findById(Long id);
}
