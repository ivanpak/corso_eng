package com.ivanpak.demotask.controller;

import com.ivanpak.demotask.model.Task;
import com.ivanpak.demotask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;



    @GetMapping("")
    public List<Task> getAllTasks(@RequestParam Optional<Boolean> completed) {
        if(completed.isEmpty()) {
            return taskService.getAllTasks();
        } else {
            return taskService.getTasksByCompletion(completed.get());
        }
    }


    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }
    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable("id") Long id) {
        taskService.removeTask(id);
    }
}
