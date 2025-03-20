package com.example.minitaskapi;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private taskRepository taskRepository;

    @Autowired
    public TaskController(taskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("ID cannot be null");
        }
        if (!taskRepository.findById(id).isPresent()) {
            throw new RuntimeException("Task not found");
        }
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete task: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        if (!taskRepository.findById(id).isPresent()) {
            throw new RuntimeException("Task not found");
        }
        Task existingTask = (Task) taskRepository.findById(id).get();
        if (updatedTask == null) {
            throw new RuntimeException("Request body is null");
        }
        if (updatedTask.getTitle() == null) {
            throw new RuntimeException("Title cannot be null");
        }
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

}
