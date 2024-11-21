package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String viewTasks(Model model) {
        List<Task> tasks = taskService.findAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam("task") String taskName) {
        taskService.addTask(taskName);
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @RequestParam("task") String updatedTaskName) {
        taskService.updateTask(id, updatedTaskName);
        return "redirect:/tasks";
    }
    
    @PostMapping("/complete/{id}")
    public String toggleCompletion(@PathVariable("id") Long id) {
        taskService.toggleCompletion(id);
        return "redirect:/tasks";
    }
}
