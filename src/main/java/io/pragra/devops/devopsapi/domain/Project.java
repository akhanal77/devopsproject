package io.pragra.devops.devopsapi.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long projectId;
    private String projectName;
    private Status status;

}
