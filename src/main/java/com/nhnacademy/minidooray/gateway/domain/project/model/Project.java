package com.nhnacademy.minidooray.gateway.domain.project.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Project {

  private Long projectNo;

  private String name;

//  private String status;

  private LocalDateTime createdAt;

  private ProjectStatus projectStatus;

  public Project() {}

  public Project(ProjectStatus projectStatus, LocalDateTime createdAt, String name, Long projectNo) {
    this.projectStatus = projectStatus;
    this.createdAt = createdAt;
    this.name = name;
    this.projectNo = projectNo;
  }
}
