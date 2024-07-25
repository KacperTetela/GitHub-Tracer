package kacpertetela.github.tracer.controller;

import kacpertetela.github.tracer.service.GitProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GitRepositoryController {
    private GitProfileService gitProfileService;

    @GetMapping("/api/v1/repositories")
    public List<?> listProfileInfo(String name) {
        return gitProfileService.find(name);
    }
}