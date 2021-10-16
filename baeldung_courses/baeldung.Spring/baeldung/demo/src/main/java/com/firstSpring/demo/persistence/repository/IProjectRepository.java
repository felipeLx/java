package com.firstSpring.demo.persistence.repository;



import com.firstSpring.demo.persistence.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
}

