package com.example.minitaskapi;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskRespository taskRespository;

    @Autowired
    public TaskController(TaskRespository taskRespository) {
        this.taskRespository = taskRespository;
    }
    @GetMapping
    public List<Task> getTasks() {
        return taskRespository.findAll();
    }
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRespository.save(task);
    }
}
