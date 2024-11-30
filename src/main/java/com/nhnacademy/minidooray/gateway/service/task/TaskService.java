package com.nhnacademy.minidooray.gateway.service.task;

import com.nhnacademy.minidooray.gateway.domain.task.request.modify.ProjectUpdateRequest;
import com.nhnacademy.minidooray.gateway.domain.task.response.read.ProjectList;
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

    public ProjectUpdateRequest modifyProject(String projectId, ProjectUpdateRequest request) {
        return taskApiClient.updateProject(projectId, request);
    }
}
