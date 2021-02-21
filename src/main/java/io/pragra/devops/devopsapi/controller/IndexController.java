package io.pragra.devops.devopsapi.controller;

import io.pragra.devops.devopsapi.repo.ProjectRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private ProjectRepo repo;

    public IndexController(ProjectRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("projects", repo.findAll());
        return "index";
    }
}
