package com.nhnacademy.minidooray.gateway.domain.project.request.register;

import lombok.Data;

@Data
public class ProjectCreateDto {

  String name;
  String adminId;

  public ProjectCreateDto() {
  }

  public ProjectCreateDto(String name, String adminId) {
    this.name = name;
    this.adminId = adminId;
  }

}
