package com.nhnacademy.minidooray.gateway.domain.task.response.read;

import com.nhnacademy.minidooray.gateway.domain.task.model.Project;
import lombok.Data;

import java.util.List;

@Data
public class ProjectList {

  List<Project> projects;

  boolean hasNext;

  boolean hasPrevious;

  long currentPage;

  public ProjectList() {}

  public ProjectList(List<Project> projects, boolean hasNext, boolean hasPrevious, long currentPage) {
    this.projects = projects;
    this.hasNext = hasNext;
    this.hasPrevious = hasPrevious;
    this.currentPage = currentPage;
  }

  public ProjectList(List<Project> projects) {
    this.projects = projects;
  }

  public ProjectList(boolean hasNext, boolean hasPrevious, long currentPage) {
    this.hasNext = hasNext;
    this.hasPrevious = hasPrevious;
    this.currentPage = currentPage;
  }
}
