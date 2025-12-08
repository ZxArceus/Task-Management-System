package com.example.task_management_system.dto;

import com.example.task_management_system.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequest {
    @NotBlank
    @Size(min=3,max=100)
    String title;
    @NotBlank
    String description;
    @NotNull
    TaskPriority priority;

    LocalDateTime duedate;
    List<String> tags;



}
