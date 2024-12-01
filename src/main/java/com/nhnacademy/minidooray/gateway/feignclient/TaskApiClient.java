package com.nhnacademy.minidooray.gateway.feignclient;

import com.nhnacademy.minidooray.gateway.domain.project.model.Project;
import com.nhnacademy.minidooray.gateway.domain.project.request.modify.ProjectUpdate;
import com.nhnacademy.minidooray.gateway.domain.project.response.register.GetProject;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "taskApi", url = "http://localhost:8082")
public interface TaskApiClient {

    @GetMapping("/users/{user_id}/projects")
    List<GetProject> getProject(@PathVariable String user_id);
}