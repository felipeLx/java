package com.firstSpring.demo.persistence.repository;


import com.firstSpring.demo.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITaskRepository extends CrudRepository<Task, Long> {

}
