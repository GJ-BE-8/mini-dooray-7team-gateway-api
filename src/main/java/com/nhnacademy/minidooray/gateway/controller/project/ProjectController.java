package com.nhnacademy.minidooray.gateway.controller.project;

import com.nhnacademy.minidooray.gateway.domain.project.model.Project;
import com.nhnacademy.minidooray.gateway.domain.project.request.modify.ProjectUpdate;
import com.nhnacademy.minidooray.gateway.domain.project.request.register.ProjectCreateDto;
import com.nhnacademy.minidooray.gateway.domain.project.response.register.GetProject;
import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
import com.nhnacademy.minidooray.gateway.service.task.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/users/{user_id}/projects")
    public List<GetProject> getProject(@PathVariable String user_id){
        return taskService.getProjectsByUserId(user_id);
    }

}
