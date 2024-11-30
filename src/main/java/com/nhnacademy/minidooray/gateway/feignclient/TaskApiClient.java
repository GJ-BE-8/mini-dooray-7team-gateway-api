package com.nhnacademy.minidooray.gateway.feignclient;

import com.nhnacademy.minidooray.gateway.domain.project.request.modify.ProjectUpdate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "taskApi", url = "http://localhost:8082")
public interface TaskApiClient {

    @GetMapping("/task/{userId}")
    TaskResponse getTasks(@PathVariable("userId") String userId);

    @PutMapping("/task/{projectId}")
    ProjectUpdate updateProject(@PathVariable("projectId") String projectId,
                                @RequestBody ProjectUpdate projectUpdateRequest);

}
