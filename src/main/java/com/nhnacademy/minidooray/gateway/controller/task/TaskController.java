package com.nhnacademy.minidooray.gateway.controller.task;

import com.nhnacademy.minidooray.gateway.domain.task.request.modify.ProjectUpdateRequest;
import com.nhnacademy.minidooray.gateway.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{userId}")
    public ProjectUpdateRequest getTasks(@PathVariable String userId) {
        return taskService.fetchTasks(userId);
    }

    @PutMapping("/{projectId}")
    public ProjectUpdateRequest updateProject(@PathVariable String projectId, @RequestBody ProjectUpdateRequest request) {
        return taskService.modifyProject(projectId, request);
    }
}