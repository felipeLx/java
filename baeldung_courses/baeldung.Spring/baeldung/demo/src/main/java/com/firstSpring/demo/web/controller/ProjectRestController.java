package com.firstSpring.demo.web.controller;

import com.firstSpring.demo.persistence.model.Project;
import com.firstSpring.demo.persistence.model.Task;
import com.firstSpring.demo.service.IProjectService;
import com.firstSpring.demo.web.dto.ProjectDto;
import com.firstSpring.demo.web.dto.TaskDto;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projectsRest")
public class ProjectRestController {

    private IProjectService projectService;

    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project entity = projectService.findById(id).orElse(null);
        return convertToDto(entity);
    }
             // (headers = "accept=application/json")
             // (consumes = "application/json")
    @PostMapping(params = "paramKey = paramValue")
    public void create(@RequestBody ProjectDto newProject) {
        Project entity = convertToEntity(newProject);
        this.projectService.save(entity);
    }

    @GetMapping
    public String getProjects(Model model) {
        Iterable<Project> projects = projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(p -> projectDtos.add(convertToDto(p)));
        model.addAttribute("projects", projectDtos);
        return "projects";
    }


    protected ProjectDto convertToDto(Project entity) {
        ProjectDto dto = new ProjectDto(entity.getId(), entity.getName(), entity.getDateCreated());
        dto.setTasks(entity.getTasks()
                .stream()
                .map(t -> convertTaskToDto(t))
                .collect(Collectors.toSet()));

        return dto;
    }

    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getDateCreated());
        if (!StringUtils.isEmpty(dto.getId())) {
            project.setId(dto.getId());
        }
        return project;
    }

    protected TaskDto convertTaskToDto(Task entity) {
        TaskDto dto = new TaskDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getDateCreated(), entity.getDueDate(), entity.getStatus());
        return dto;
    }

    protected Task convertTaskToEntity(TaskDto dto) {
        Task task = new Task(dto.getName(), dto.getDescription(), dto.getDateCreated(), dto.getDueDate(), dto.getStatus());
        if (!StringUtils.isEmpty(dto.getId())) {
            task.setId(dto.getId());
        }
        return task;
    }
}
