package com.nhnacademy.minidooray.gateway.domain.project.response.register;

import com.nhnacademy.minidooray.gateway.domain.project.model.ProjectStatus;
import lombok.Data;

@Data
public class GetProject {
    long projectId;
    String projectName;
    ProjectStatus projectStatus;

    public GetProject() {}

    public GetProject(long projectId, String projectName, ProjectStatus projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }
}