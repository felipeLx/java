package com.felipelisboa.test.persistence.repository;

import com.felipelisboa.test.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
