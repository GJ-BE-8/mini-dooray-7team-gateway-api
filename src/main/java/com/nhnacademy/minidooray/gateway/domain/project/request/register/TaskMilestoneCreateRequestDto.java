package com.nhnacademy.minidooray.gateway.domain.project.request.register;

import lombok.Data;

@Data
public class TaskMilestoneCreateRequestDto {

  private Integer taskId;

  private Integer milestoneId;

  public TaskMilestoneCreateRequestDto() {
  }

  public TaskMilestoneCreateRequestDto(Integer taskId, Integer milestoneId) {
    this.taskId = taskId;
    this.milestoneId = milestoneId;
  }
}
