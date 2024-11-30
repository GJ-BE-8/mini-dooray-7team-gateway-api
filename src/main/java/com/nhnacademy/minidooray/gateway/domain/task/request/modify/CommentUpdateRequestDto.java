package com.nhnacademy.minidooray.gateway.domain.task.request.modify;

import lombok.Data;

@Data
public class CommentUpdateRequestDto {

  private String content;

  public CommentUpdateRequestDto() {}

  public CommentUpdateRequestDto(String content) {
    this.content = content;
  }
}
