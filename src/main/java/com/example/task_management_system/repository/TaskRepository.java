package com.example.task_management_system.repository;

import com.example.task_management_system.enums.TaskPriority;
import com.example.task_management_system.enums.TaskStatus;
import com.example.task_management_system.model.Task;
import com.example.task_management_system.model.User;
import io.lettuce.core.GeoArgs;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    Optional<Task> findByUserId(ObjectId userId);
    List<Task>findAllByUserId(ObjectId userId, Sort sort);
    List<Task>findByUserIdAndStatus(ObjectId userId,  TaskStatus status);
    Optional<List<Task>> findByUserIdAndPriority (ObjectId userId, TaskPriority priority);

    List<Task> findByUserIdAndDueDateBeforeAndStatusNot(

            LocalDateTime date,
            TaskStatus status
    );


    Long countByUserIdAndStatus(String userId,TaskStatus status);


    Optional<Task> findByUserIdOrderByPriorityDescCreatedAtDesc(ObjectId userId);
    boolean existsByIdAndUserId(ObjectId id,ObjectId userId);
    Optional<Task> findByIdAndUserId(ObjectId id,ObjectId userId);
    List<Task> findByUserIdAndTags(ObjectId userId, String tag);


    void deleteByUserId(ObjectId taskId);



}
