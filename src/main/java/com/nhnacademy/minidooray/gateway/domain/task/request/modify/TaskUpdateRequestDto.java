package com.nhnacademy.minidooray.gateway.domain.task.request.modify;

import lombok.Data;

@Data
public class TaskUpdateRequestDto {

  private String title;

  private String content;

  public TaskUpdateRequestDto() {}

  public TaskUpdateRequestDto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
