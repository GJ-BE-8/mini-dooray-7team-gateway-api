package com.nhnacademy.minidooray.gateway.domain.task.request.modify;

import lombok.Data;

@Data
public class TagUpdateRequestDto {

  private String name;

  public TagUpdateRequestDto() {}

  public TagUpdateRequestDto(String name) {
    this.name = name;
  }
}
