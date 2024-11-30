package com.nhnacademy.minidooray.gateway.domain.project.request.modify;

import lombok.Data;

@Data
public class ProjectUpdate {

  private String name;
  private String status;

  public ProjectUpdate() {}

  public ProjectUpdate(String name, String status) {
    this.name = name;
    this.status = status;
  }
}

