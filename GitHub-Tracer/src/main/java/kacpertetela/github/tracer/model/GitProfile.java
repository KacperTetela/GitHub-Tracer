package kacpertetela.github.tracer.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class GitProfile {
    private List<GitRepository> repositories;
}