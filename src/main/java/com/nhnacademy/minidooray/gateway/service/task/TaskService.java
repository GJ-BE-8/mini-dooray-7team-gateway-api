package com.nhnacademy.minidooray.gateway.service.task;

import com.nhnacademy.minidooray.gateway.domain.project.request.modify.ProjectUpdate;
import com.nhnacademy.minidooray.gateway.domain.project.response.read.ProjectList;
import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskApiClient taskApiClient;

    @Autowired
    public TaskService(TaskApiClient taskApiClient) {
        this.taskApiClient = taskApiClient;
    }

    public ProjectList fetchTasks(String userId) {
        return taskApiClient.getTasks(userId);
    }

    public ProjectUpdate modifyProject(String projectId, ProjectUpdate request) {
        return taskApiClient.updateProject(projectId, request);
    }
}
