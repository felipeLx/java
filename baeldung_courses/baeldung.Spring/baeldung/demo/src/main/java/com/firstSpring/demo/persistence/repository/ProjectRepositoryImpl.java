package com.firstSpring.demo.persistence.repository;
/*
** project was code blocked after the implementation of the 'extends CrudRepository<Project, Long>'
*/

/*
import com.firstSpring.demo.persistence.model.Project;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Profile("dev")
public class ProjectRepositoryImpl implements IProjectRepository{

    private 
    List<Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if(existingProject == null) {
            projects.add(project);
            return project;
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
            return project;
        }
    }
}
*/
