package br.com.scc4.tms.repository.main;

import br.com.scc4.tms.model.main.Empresa;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("dev")
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByCnpj(String cnpj);

    Optional<Empresa> findFirst1ByPlataformaId(Long idPlataforma);
}
