package io.pragra.devops.devopsapi.controller;

import io.pragra.devops.devopsapi.domain.Project;
import io.pragra.devops.devopsapi.domain.Status;
import io.pragra.devops.devopsapi.repo.ProjectRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectRepo repo;

    public ProjectController(ProjectRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/project/{projectId}")
    public Project getProject(@PathVariable Long projectId) {
        return repo.findById(projectId).orElse(Project.builder().build());
    }


    @PostMapping("/project")
    public Project createProject(@RequestBody Project project) {
        return repo.save(project);
    }

    @GetMapping("/project")
    public List<Project> getProjects() {
        return repo.findAll();
    }

}
