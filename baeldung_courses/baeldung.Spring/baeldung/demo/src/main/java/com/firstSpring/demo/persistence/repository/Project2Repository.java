package com.firstSpring.demo.persistence.repository;
/*
** code blocked to the phase Interface implementation: I2ProjectRepository and ITaskRepository
 */

/*import com.firstSpring.demo.persistence.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class Project2Repository implements I2ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Project> findById(Long id) {
        Project entity = entityManager.find(Project.class, id);

        return Optional.ofNullable(entity);

    }

    @Override
    @Transactional
    public Project save(Project project) {
        entityManager.persist(project);

        return project;
    }
}*/
