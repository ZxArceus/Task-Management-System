package com.example.task_management_system.ServiceTest;

import com.example.task_management_system.repository.TaskRepository;
import com.example.task_management_system.service.TaskService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;
}
