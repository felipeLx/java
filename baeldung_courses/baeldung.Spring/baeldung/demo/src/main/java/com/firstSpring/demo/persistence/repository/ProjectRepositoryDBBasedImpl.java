package com.firstSpring.demo.persistence.repository;

/*
import com.firstSpring.demo.persistence.model.Project;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class ProjectRepositoryDBBasedImpl implements IProjectRepository {

//    @Value("${project.prefix}")
//    private String prefix;
//    @Value("${project.suffix}")
//    private Integer suffix;

    private List<Project> projects = new ArrayList<>();

    public ProjectRepositoryDBBasedImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
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
