package com.nhnacademy.minidooray.gateway.domain.project.request.register;

import lombok.Data;

@Data
public class TaskCreateDto {

  private String title;
  private String content;
  private String writerId;
  private Integer projectId;

}
