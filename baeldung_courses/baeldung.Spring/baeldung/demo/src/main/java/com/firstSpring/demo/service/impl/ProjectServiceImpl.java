package com.firstSpring.demo.service.impl;

import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.persistence.model.Task;
import com.firstSpring.demo.persistence.repository.IProjectRepository;
import com.firstSpring.demo.service.IProjectService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private IProjectRepository projectRepository;

    public ProjectServiceImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        if(StringUtils.isEmpty(project.getId())) {
            project.setDateCreated(LocalDate.now());
        }
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project addTasks(Project project, List<Task> tasks) {
        project.getTasks()
                .addAll(tasks.stream()
                .filter(t -> !StringUtils.isEmpty(t.getName()))
                .collect(Collectors.toList()));
        projectRepository.save(project);

        return project;
    }
}
