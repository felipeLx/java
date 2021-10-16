package br.com.scc4.tms.repository.tenant;

import br.com.scc4.tms.model.tenant.EmbarcadorDpto;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public interface EmbarcadorDptoRepository extends JpaRepository<EmbarcadorDpto, Long> {

    List<EmbarcadorDpto> embarcadorDptosList = new ArrayList<>();

    public Optional<EmbarcadorDpto> findById(Long id);
}
