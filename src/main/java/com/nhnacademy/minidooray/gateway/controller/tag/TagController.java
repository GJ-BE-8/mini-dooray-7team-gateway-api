//package com.nhnacademy.minidooray.gateway.controller.tag;
//
//import com.nhnacademy.minidooray.gateway.domain.tag.model.Tag;
//import com.nhnacademy.minidooray.gateway.domain.tag.request.TagUpdateCreateDto;
//import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Set;
//
//@RestController
//@RequestMapping("/tags")
//public class TagController {
//
//    private final TaskApiClient taskApiClient;
//
//    public TagController(TaskApiClient taskApiClient) {
//        this.taskApiClient = taskApiClient;
//    }
//
//    @PostMapping("/fetch")
//    public boolean createOrUpdateTag(@RequestBody TagUpdateCreateDto tagUpdateCreateDto) {
//        return taskApiClient.fetchTag(tagUpdateCreateDto);
//    }
//
//    @GetMapping("/{taskId}")
//    public Set<Tag> getTags(@PathVariable String taskId) {
//        return taskApiClient.getTags(taskId);
//    }
//
//    @DeleteMapping("/delete")
//    public boolean deleteTag(@RequestBody String tagId) {
//        return taskApiClient.deleteTag(tagId);
//    }
//}