package kacpertetela.github.tracer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class GitRepository {
    private String name;
    private String ownerLogin;
    private boolean fork;
}