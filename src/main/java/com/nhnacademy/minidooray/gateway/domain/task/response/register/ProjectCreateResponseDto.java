package com.nhnacademy.minidooray.gateway.domain.task.response.register;

import lombok.Data;

@Data
public class ProjectCreateResponseDto {

  private String adminId;

  private Integer projectId;

  private String name;

  private String status;

  public ProjectCreateResponseDto() {}

  public ProjectCreateResponseDto(String adminId, Integer projectId, String name, String status) {
    this.adminId = adminId;
    this.projectId = projectId;
    this.name = name;
    this.status = status;
  }
}
