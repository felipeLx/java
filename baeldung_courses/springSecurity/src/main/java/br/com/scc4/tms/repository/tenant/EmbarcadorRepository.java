package br.com.scc4.tms.repository.tenant;

import br.com.scc4.tms.model.tenant.Embarcador;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public interface EmbarcadorRepository extends JpaRepository<Embarcador, Long> {


    List<Embarcador> embarcadorList = new ArrayList<>();

    public Optional<Embarcador> findById(Long id) ;
}
