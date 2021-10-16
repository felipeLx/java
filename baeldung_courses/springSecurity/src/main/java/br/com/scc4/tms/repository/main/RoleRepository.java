package br.com.scc4.tms.repository.main;

import br.com.scc4.tms.model.main.Role;
import br.com.scc4.tms.model.main.RoleName;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("dev")
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
