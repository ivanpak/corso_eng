package com.ivanpak.demotask.service;

import com.ivanpak.demotask.model.Task;
import com.ivanpak.demotask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> opt = taskRepository.findById(id);
        if(opt.isEmpty()) {
            throw new RuntimeException();
        } else {
            return opt.get();
        }
    }

    @Override
    public List<Task> getTasksByCompletion(Boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> opt = taskRepository.findById(id);
        Task t1 = null;
        if(opt.isEmpty()) {
            throw new RuntimeException();
        } else {
            t1 = opt.get();
        }
        t1.setTitle(task.getTitle());
        t1.setDescription(task.getDescription());
        t1.setCompleted(task.getCompleted());
        return taskRepository.save(t1);
    }

    @Override
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }
}
