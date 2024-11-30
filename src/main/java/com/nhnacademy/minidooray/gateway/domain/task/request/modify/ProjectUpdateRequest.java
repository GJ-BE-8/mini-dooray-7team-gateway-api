package com.nhnacademy.minidooray.gateway.domain.task.request.modify;

import lombok.Data;

@Data
public class ProjectUpdateRequest {

  private String name;
  private String status;

  public ProjectUpdateRequest() {}

  public ProjectUpdateRequest(String name, String status) {
    this.name = name;
    this.status = status;
  }
}

