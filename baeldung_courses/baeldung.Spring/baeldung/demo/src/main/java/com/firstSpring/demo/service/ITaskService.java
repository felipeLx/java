package com.firstSpring.demo.service;

import com.firstSpring.demo.persistence.model.Task;

import java.util.Optional;

public interface ITaskService {

    Optional<Task> findById(Long id);
    Task save(Task project);
}
