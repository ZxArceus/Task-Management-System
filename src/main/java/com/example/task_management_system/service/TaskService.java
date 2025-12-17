package com.example.task_management_system.service;

import com.example.task_management_system.dto.TaskCreateRequest;
import com.example.task_management_system.dto.TaskResponse;
import com.example.task_management_system.enums.TaskStatus;
import com.example.task_management_system.exception.AuthorizationException;
import com.example.task_management_system.exception.ResourceNotFoundException;
import com.example.task_management_system.model.Task;
import com.example.task_management_system.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse createTask(TaskCreateRequest request, ObjectId userId) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setId(userId);
        task.setStatus(TaskStatus.PENDING);
        LocalDateTime dateTime = LocalDateTime.now();
        task.setCreatedAt(dateTime);
        task.setUpdatedAt(dateTime);
        Task saved = taskRepository.save(task);
        return mapToResponse(saved);
    }

    public TaskResponse getTaskById(ObjectId taskId, ObjectId userId) {
        if (!taskRepository.existsById(taskId)) {
            throw new ResourceAccessException("resource not found");
        }
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found with Id"));

        if (!task.getUserId().equals(userId)) {
            throw new AuthorizationException();

        }

        return mapToResponse(task);
    }

    public List<TaskResponse> getAlltask(ObjectId userId) {


        Sort sort = Sort.by(Sort.Direction.DESC,"priority")
                .and(Sort.by(Sort.Direction.DESC, "createdAt"));
        if (taskRepository.findAllByUserId(userId, sort) == null) {
            throw new ResourceNotFoundException("No Tasks Found");
        }
        List<Task> tasks = taskRepository.findAllByUserId(userId, sort);
        return tasks.stream()
                .map(this::mapToResponse)
                .toList();

    }
    public List<TaskResponse> getTaskByStatus(ObjectId userId, TaskStatus taskStatus) {
        if(taskRepository.findByUserIdAndStatus(userId,taskStatus)==null){
            throw new ResourceNotFoundException("no such Tasks with this priority");
        }
        List<Task> tasks = taskRepository.findByUserIdAndStatus(userId, taskStatus);
        return  tasks.stream()
                .map(this::mapToResponse)
                .toList();
    }
    public void deleteTask(ObjectId taskId,ObjectId userId){
        Task task = taskRepository
                .findByIdAndUserId(taskId,userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found or access denied")
                );

        // Delete the task
        taskRepository.deleteById(taskId);
    }
    public List<TaskResponse> getOverdueTasks() {

        LocalDateTime now = LocalDateTime.now();

        List<Task> tasks = taskRepository
                .findByUserIdAndDueDateBeforeAndStatusNot(now, TaskStatus.COMPLETED);

        return tasks.stream()
                .map(this::mapToResponse)
                .toList();
    }
    public  TaskResponse markTaskComplete(ObjectId taskId,ObjectId userId){
        Task task = taskRepository
                .findByIdAndUserId(taskId, userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found or access denied")
                );
        task.setStatus(TaskStatus.COMPLETED);
        LocalDateTime dateTime=LocalDateTime.now();
        task.setCompletedAt(dateTime);
        task.setUpdatedAt(dateTime);
        Task updatedTask = taskRepository.save(task);
        return  mapToResponse(updatedTask);
    }

    private TaskResponse mapToResponse(Task task) {

        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setStatus(task.getStatus());
        response.setDescription(task.getDescription());
        response.setTitle(task.getTitle());
        response.setCreatedAt(task.getCreatedAt());
        response.setUpdatedAt(task.getUpdatedAt());
        response.setUserId(task.getUserId());
        return response;

    }
}
