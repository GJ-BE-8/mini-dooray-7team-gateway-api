package com.nhnacademy.minidooray.gateway.domain.project.request.register;

import lombok.Data;

@Data
public class TagCreateDto {

  private Integer projectId;

  private String name;

  public TagCreateDto() {}

  public TagCreateDto(Integer projectId, String name) {
    this.projectId = projectId;
    this.name = name;
  }
}
