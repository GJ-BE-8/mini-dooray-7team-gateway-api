package com.nhnacademy.minidooray.gateway.domain.task.request.register;

import lombok.Data;

@Data
public class CommentCreateDto {

  private Integer taskId;

  private String writerId;

  private String content;

  public CommentCreateDto() {}

  public CommentCreateDto(Integer taskId, String writerId, String content) {
    this.taskId = taskId;
    this.writerId = writerId;
    this.content = content;
  }
}
