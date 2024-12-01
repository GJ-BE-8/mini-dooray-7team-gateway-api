//package com.nhnacademy.minidooray.gateway.controller.comment;
//
//import com.nhnacademy.minidooray.gateway.domain.task.model.Task;
//import com.nhnacademy.minidooray.gateway.domain.task.request.TaskUpdateCreateDto;
//import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/comments")
//public class CommentController {
//
//    private final TaskApiClient taskApiClient;
//
//    public CommentController(TaskApiClient taskApiClient) {
//        this.taskApiClient = taskApiClient;
//    }
//
//    @GetMapping("/{taskId}")
//    public Set<Task> getComments(@PathVariable String taskId) {
//        return taskApiClient.getComments(taskId);
//    }
//
//    @PutMapping("/fetch")
//    public boolean createOrUpdateComment(@RequestBody TaskUpdateCreateDto taskUpdateCreateDto) {
//        return taskApiClient.fetchComment(taskUpdateCreateDto);
//    }
//
//    @PostMapping("/delete")
//    public boolean deleteComment(@RequestBody String commentId) {
//        return taskApiClient.deleteComment(commentId);
//    }
//}