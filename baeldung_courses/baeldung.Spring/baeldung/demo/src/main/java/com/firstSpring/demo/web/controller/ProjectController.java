package com.firstSpring.demo.web.controller;

// code blocked tu use MVC and not Rest

/*import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.service.IProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.firstSpring.demo.web.dto.ProjectDto;


@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectController() {
        super();
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project entity = projectService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto newProject) {
        this.projectService.save(convertToEntity(newProject));
    }

    private ProjectDto convertToDto(Project entity) {
        return new ProjectDto(entity.getId(), entity.getName());
    }

    private Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), null);
        if(StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return project;
    }
}*/
