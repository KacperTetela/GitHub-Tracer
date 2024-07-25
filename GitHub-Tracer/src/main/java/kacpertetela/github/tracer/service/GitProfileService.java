package kacpertetela.github.tracer.service;

import kacpertetela.github.tracer.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class GitProfileService {
    private static final String URL_REPOS = "https://api.github.com/users/%s/repos";
    private static final String URL_BRANCHES = "https://api.github.com/repos/%s/%s/branches";
    private final RestTemplate restTemplate;

    public GitProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<?> find(String gitHubUsername) {
        try {
            GitRepository[] repositories = restTemplate.getForObject(String.format(URL_REPOS, gitHubUsername), GitRepository[].class);
            return Arrays.stream(repositories)
                    .filter(repo -> !repo.isFork())
                    .map(repo -> createResponseRepo(gitHubUsername, repo))
                    .toList();
        } catch (HttpClientErrorException e) {
            return List.of(createResponseException(e.getStatusCode().value(), e.getStatusText()));
        }
    }

    private ResponseGitRepository createResponseRepo(String gitHubUsername, GitRepository gitRepository) {
        String format = String.format(URL_BRANCHES, gitHubUsername, gitRepository.getName());
        GitBranch[] fullBranches = restTemplate.getForObject(format, GitBranch[].class);
        List<ResponseGitBranch> responseBranches = Arrays.stream(fullBranches)
                .map(branch -> new ResponseGitBranch(branch.getName(), branch.getCommit().getSha()))
                .toList();
        return new ResponseGitRepository(gitRepository.getName(), responseBranches);
    }

    private ResponseGitException createResponseException(int statusCode, String message) {
        switch (statusCode) {
            case 404 -> {
                return new ResponseGitException(statusCode, "GitHub user has not been found");
            }
            case 403 -> {
                return new ResponseGitException(statusCode, "GitHub API requests limit exceeded");
            }
            default -> {
                return new ResponseGitException(statusCode, message);
            }
        }
    }
}
