package com.ivanpak.demotask.service;

import com.ivanpak.demotask.exception.NoDataFoundException;
import com.ivanpak.demotask.model.Task;
import com.ivanpak.demotask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @Cacheable("tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    @Cacheable("tasks")
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public List<Task> getTasksByCompletion(Boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public Task saveTask(Task task) {
        task.setInsertionDate(LocalDate.now());
        task.setUpdateDate(LocalDate.now());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task t1 = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        t1.setTitle(task.getTitle());
        t1.setDescription(task.getDescription());
        t1.setCompleted(task.getCompleted());
        t1.setUpdateDate(LocalDate.now());
        return taskRepository.save(t1);
    }

    @Override
    @CacheEvict("tasks")
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
        cacheManager.getCache("tasks").evict(SimpleKey.EMPTY);
    }

    @CacheEvict(allEntries = true, cacheNames = "tasks")
    // @Scheduled(initialDelay = 2000, fixedDelay = 2000)
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void clear() {
        System.out.println("svuoto cache");
    }
}
