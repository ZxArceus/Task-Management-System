package com.example.task_management_system.controller;

import com.example.task_management_system.dto.ApiResponse;
import com.example.task_management_system.dto.TaskCreateRequest;
import com.example.task_management_system.dto.TaskResponse;
import com.example.task_management_system.dto.TaskUpdateRequest;
import com.example.task_management_system.enums.TaskStatus;
import com.example.task_management_system.service.TaskService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<ApiResponse> createTask(@RequestBody TaskCreateRequest request, @RequestParam ObjectId userId){
        TaskResponse response=taskService.createTask(request,userId);
        return new ResponseEntity<>(ApiResponse.success("Task created",response) , HttpStatus.CREATED);

    }

    @GetMapping("/find/{taskId}/{userId}")
    public  ResponseEntity<ApiResponse> findTaskById(@RequestParam ObjectId taskId,@RequestParam ObjectId userId){
        TaskResponse response=taskService.getTaskById(taskId,userId);
        return  new ResponseEntity<>(ApiResponse.success("Task Found",response),HttpStatus.FOUND);
    }

    @GetMapping("/find/{userId}")
    public  ResponseEntity<ApiResponse> getAllTasks(@RequestParam ObjectId userId){
        List<TaskResponse> response=taskService.getAllTask(userId);
        return  new ResponseEntity<>(ApiResponse.success("Tasks Found",response),HttpStatus.FOUND);
    }

    @GetMapping("/find/{userid}/{status}")
    public  ResponseEntity<ApiResponse> getTaskByStatus(@RequestParam ObjectId userid, @RequestParam TaskStatus status){
        List<TaskResponse> response=taskService.getTaskByStatus(userid,status);
        return  new ResponseEntity<>(ApiResponse.success("Tasks Found",response),HttpStatus.FOUND);
    }

    @PutMapping("/update/{taskId}/{userId}")
    public ResponseEntity<ApiResponse> updateTask(
            @RequestParam  ObjectId taskId,
            @RequestBody TaskUpdateRequest request,
            @RequestParam ObjectId userId){
        TaskResponse response =taskService.updateTask(taskId,request,userId);
        return  new ResponseEntity<>(ApiResponse.success("Tasks Updated",response),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{taskId}/{userId}")
    public ResponseEntity<ApiResponse> deleteTask(@RequestParam ObjectId taskId,@RequestParam ObjectId userId){
        taskService.deleteTask(taskId,userId);
        return  new ResponseEntity<>(ApiResponse.success("Tasks Deleted"),HttpStatus.OK);
    }

    @GetMapping("/overdue/{userId}")
    public  ResponseEntity<ApiResponse> getOverDueTasksById(@RequestParam ObjectId userId){
        List<TaskResponse> response=taskService.getOverdueTasks(userId);
        return  new ResponseEntity<>(ApiResponse.success("Tasks Found",response),HttpStatus.FOUND);
    }

    @PatchMapping("/complete/{taskId}/{userId}")
    public  ResponseEntity<ApiResponse> markComplete(@RequestParam ObjectId taskId,@RequestParam ObjectId userId){
        TaskResponse response=taskService.markTaskComplete(taskId,userId);
        return  new ResponseEntity<>(ApiResponse.success("Task Mark As Completed",response),HttpStatus.OK);
    }



}
