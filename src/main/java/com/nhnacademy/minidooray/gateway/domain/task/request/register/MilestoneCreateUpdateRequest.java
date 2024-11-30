package com.nhnacademy.minidooray.gateway.domain.task.request.register;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MilestoneCreateUpdateRequest {

  private Integer projectId;

  private String name;

  private LocalDate startAt;

  private LocalDate endAt;

  public MilestoneCreateUpdateRequest() {}

  public MilestoneCreateUpdateRequest(Integer projectId, String name, LocalDate startAt, LocalDate endAt) {
    this.projectId = projectId;
    this.name = name;
    this.startAt = startAt;
    this.endAt = endAt;
  }
}
