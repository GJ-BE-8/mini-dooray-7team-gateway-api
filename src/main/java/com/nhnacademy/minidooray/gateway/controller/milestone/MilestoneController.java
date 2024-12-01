//package com.nhnacademy.minidooray.gateway.controller.milestone;
//
//import com.nhnacademy.minidooray.gateway.domain.milestone.model.MileStone;
//import com.nhnacademy.minidooray.gateway.domain.milestone.register.MilestoneCreateUpdateDto;
//import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/milestones")
//public class MilestoneController {
//
//    private final TaskApiClient taskApiClient;
//
//    public MilestoneController(TaskApiClient taskApiClient) {
//        this.taskApiClient = taskApiClient;
//    }
//
//    @PostMapping("/fetch")
//    public boolean createOrUpdateMilestone(@RequestBody MilestoneCreateUpdateDto milestoneCreateUpdateDto) {
//        return taskApiClient.fetchMilestone(milestoneCreateUpdateDto);
//    }
//
//    @GetMapping("/{taskId}")
//    public MileStone getMilestone(@PathVariable String taskId) {
//        return taskApiClient.getMilestones(taskId);
//    }
//
//    @DeleteMapping("/delete")
//    public boolean deleteMilestone(@RequestBody String milestoneId) {
//        return taskApiClient.deleteMilestone(milestoneId);
//    }
//}