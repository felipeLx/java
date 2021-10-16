package com.felipelisboa.test.service;

import com.felipelisboa.test.persistence.model.Project;
import com.felipelisboa.test.persistence.model.Task;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);
    Project save(Project project);

    Iterable<Project> findAll();

    Project addTasks(Project project, List<Task> tasks);
}
