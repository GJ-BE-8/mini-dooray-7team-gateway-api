package com.nhnacademy.minidooray.gateway.service.task;

import com.nhnacademy.minidooray.gateway.domain.project.request.modify.ProjectUpdate;
import com.nhnacademy.minidooray.gateway.domain.project.response.read.ProjectList;
import com.nhnacademy.minidooray.gateway.domain.project.response.register.GetProject;
import com.nhnacademy.minidooray.gateway.domain.task.TaskUpdateRequestDto;

import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskService {
    private final TaskApiClient taskApiClient;

    @Autowired
    public TaskService(TaskApiClient taskApiClient) {
        this.taskApiClient = taskApiClient;
    }

    public List<GetProject> getProjectsByUserId(String userId) {
        return taskApiClient.getProject(userId);
    }
}

