package com.firstSpring.demo.service.typeOfInjection;

/*
import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.repository.IProjectRepository;
import com.firstSpring.demo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class ProjectServiceImplSetterInjection implements IProjectService {


    private IProjectRepository repository;

    public ProjectServiceImplSetterInjection(IProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Autowired
    @Qualifier("projectRepositoryImpl2")
    public void setRepository(IProjectRepository repository) {
        this.repository = repository;
    }
}
*/
