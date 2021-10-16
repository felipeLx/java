package com.firstSpring.demo.repository;

import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.persistence.repository.IProjectRepository;
import org.hibernate.procedure.internal.ProcedureCallImpl;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) -> that is used for com.firstSpring.demo.web environment tests
// @WebMvcTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
// @Disabled
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSucess() {

        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        assertNotNull(projectRepository.save(newProject));
        // assertThat(projectRepository.save(newProject), is(notNullValue()));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findById(newProject.getId());
        assertEquals(retrievedProject.get(), newProject);
        //assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

 /*   @Test
    public void givenProject_whenFindByName_thenSuccess() {
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);
        Optional<Project> retrievedProject = projectRepository.findByName(newProject.getName());
        assertEquals(retrievedProject.get(), newProject);
        //assertThat(retrievedProject.get(), is(equalTo(newProject)));
    }

    @Test
    public void givenProjectCreated_whenFindByDateCreatedBetween_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Project newProject2 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        assertThat(retrievedProjects, hasItems(newProject, newProject2));
    }*/

   /* @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));

        assertThat(retrievedProjects.getContent(), hasSize(2));
    }*/


}