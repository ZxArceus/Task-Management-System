package com.example.task_management_system.dto;

import com.example.task_management_system.enums.TaskPriority;
import com.example.task_management_system.enums.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequest {
    @Size(min=3,max=100)
    String title;
    @Size(max = 500)
    String description;
    TaskPriority priority;
    TaskStatus status;

    LocalDateTime dueDate;

    List<String> tags;

}
