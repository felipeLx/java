package com.felipelisboa.test.persistence.repository;

import com.felipelisboa.test.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProject extends JpaRepository<Project, Long> {
}
