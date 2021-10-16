package com.felipelisboa.test.persistence.repository;

import com.felipelisboa.test.persistence.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task, Long> {

}
