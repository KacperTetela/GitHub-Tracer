package kacpertetela.github.tracer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class GitBranch {
    private String name;
    private GitCommit commit;
}
