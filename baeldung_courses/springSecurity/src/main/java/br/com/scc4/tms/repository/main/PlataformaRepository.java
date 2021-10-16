package br.com.scc4.tms.repository.main;

import br.com.scc4.tms.model.main.Plataforma;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("dev")
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

    Optional<Plataforma> findByNomePlataforma(String nomePlataforma);
}
