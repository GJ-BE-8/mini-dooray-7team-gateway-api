//package com.nhnacademy.minidooray.gateway.controller.task;
//
//import com.nhnacademy.minidooray.gateway.domain.task.model.Task;
//import com.nhnacademy.minidooray.gateway.domain.task.request.TaskUpdateCreateDto;
//import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
//import com.nhnacademy.minidooray.gateway.service.task.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/taskApi")
//public class TaskController {
//
//    private final TaskService taskService;
//    private final TaskApiClient taskApiClient;
//
//    @Autowired
//    public TaskController(TaskService taskService, TaskApiClient taskApiClient) {
//        this.taskService = taskService;
//        this.taskApiClient = taskApiClient;
//    }
//
//    //projectId을 통해서 그 안에 속에 있는 task 받아옴
//    @GetMapping("/{projectId}")
//    public Set<Task> getTasks(@PathVariable String projectId) {
//        //todo taskapi에 Set<Task> 값 요청후 이를 출력(Set으로 중복값 방지)
//        return taskApiClient.getTasks(projectId);
//    }
//
//    //업데이트할 task을 받아와서 taskapi에 그 값을 전달해서 데이터베이스 변경
//    @PutMapping("/")
//    public String updateTask(@RequestBody TaskUpdateCreateDto taskUpdateCreateDto) {
//        boolean result = taskApiClient.fetchTask(taskUpdateCreateDto);   //변경 성공 여부 확인용
//
//        if (result) {
//            return "변경 완";
//        }
//
//        return "알맞지 않는 task입니다.";
//    }
//}