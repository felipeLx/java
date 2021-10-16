package com.firstSpring.demo.service.impl;

import com.firstSpring.demo.persistence.model.Task;
import com.firstSpring.demo.persistence.repository.ITaskRepository;
import com.firstSpring.demo.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class TaskServiceImpl implements ITaskService {

    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task project) {
        return taskRepository.save(project);
    }

}
