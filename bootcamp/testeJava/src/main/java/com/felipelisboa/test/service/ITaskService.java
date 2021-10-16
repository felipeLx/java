package com.felipelisboa.test.service;

import com.felipelisboa.test.persistence.model.Task;

import java.util.Optional;

public interface ITaskService {

    Optional<Task> findById(Long id);
    Task save(Task project);
}

