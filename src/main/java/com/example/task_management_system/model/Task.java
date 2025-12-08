package com.example.task_management_system.model;

import com.example.task_management_system.enums.TaskPriority;
import com.example.task_management_system.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private ObjectId id;
    private  String title;
    private  String description;
    @Indexed
    private  ObjectId  userId;
    private TaskStatus status=TaskStatus.PENDING;
    private TaskPriority priority;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private  LocalDateTime updatedAt;

    private LocalDateTime dueDate;
    private List<String> tags=new ArrayList<>();
    private  String assignedTo;
    private  LocalDateTime completedAt;


}
