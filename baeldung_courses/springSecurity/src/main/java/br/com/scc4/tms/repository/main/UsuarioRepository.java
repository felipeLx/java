package br.com.scc4.tms.repository.main;

import br.com.scc4.tms.model.main.Usuario;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("dev")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    Usuario findByEmail(String email);

    void deleteByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Usuario> findByUsername(String username);

    Boolean existsByUsername(String username);

}