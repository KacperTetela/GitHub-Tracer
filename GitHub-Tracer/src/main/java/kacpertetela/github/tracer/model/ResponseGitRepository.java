package kacpertetela.github.tracer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ResponseGitRepository {
    private String name;
    private List<ResponseGitBranch> branches;
}
