package com.example.task_management_system.dto;

import com.example.task_management_system.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    ObjectId id;
    String title;
    String description;
    ObjectId userId;
    TaskStatus status;
    LocalDateTime dueDate;
    List<String> tags;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime completedAt;

}
