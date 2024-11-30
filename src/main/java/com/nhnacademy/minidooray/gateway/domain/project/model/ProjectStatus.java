package com.nhnacademy.minidooray.gateway.domain.project.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum ProjectStatus {
  ACTIVE, SLEEP, END;


  public String getName() {
    return this.name();
  }
}
