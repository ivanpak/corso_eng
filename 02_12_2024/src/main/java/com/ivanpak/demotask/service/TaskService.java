package com.ivanpak.demotask.service;

import org.springframework.stereotype.Service;
import com.ivanpak.demotask.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();
    public Task getTaskById(Long id);
    public List<Task> getTasksByCompletion(Boolean bool);
    public Task saveTask(Task task);
    public Task updateTask(Long id, Task task);
    public void removeTask(Long id);

}
