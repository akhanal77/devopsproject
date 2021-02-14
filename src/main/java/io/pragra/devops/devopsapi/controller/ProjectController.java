package io.pragra.devops.devopsapi.controller;

import io.pragra.devops.devopsapi.domain.Project;
import io.pragra.devops.devopsapi.domain.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @GetMapping("/project")
    public Project getProject() {
        return Project
                .builder()
                .projectId(2L)
                .projectName("DevOps Project")
                .status(Status.NEW)
                .build();
    }
}
