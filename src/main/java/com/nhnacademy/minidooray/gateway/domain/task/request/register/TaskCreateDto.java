package com.nhnacademy.minidooray.gateway.domain.task.request.register;

import lombok.Data;

@Data
public class TaskCreateDto {

  private String title;

  private String content;

  private String writerId;

  private Integer projectId;

  public TaskCreateDto() {}

  public TaskCreateDto(String title, String content, String writerId, Integer projectId) {
    this.title = title;
    this.content = content;
    this.writerId = writerId;
    this.projectId = projectId;
  }
}
