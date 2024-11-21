
package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(String taskName) {
        Task task = new Task();
        task.setTask(taskName);
        task.setCompleted(false); // New tasks are not completed
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(Long id, String updatedTaskName) {
        Task task = taskRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
        task.setTask(updatedTaskName);
        taskRepository.save(task);
    }
    
    public Task findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
    }
    
    public void toggleCompletion(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
