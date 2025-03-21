package com.example.minitaskapi;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    @Transactional // Add this annotation
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("ID cannot be null"); // 400 Bad Request
        }
        try {
            if (taskRepository.findById(id).isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found"); // 404 Not Found
            }
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Delete failed: " + e.getMessage()); // 500 Internal Server Error
        }
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        if (taskRepository.findById(id).isPresent()) {
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
        } else {
            throw new RuntimeException("Task not found");
        }
    }

}