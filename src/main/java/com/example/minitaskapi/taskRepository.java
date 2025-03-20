package com.example.minitaskapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface taskRepository extends JpaRepository<Task, Integer> {

    List<Task> id(Long id);

    Optional<Object> findById(Long id);

    void deleteById(Long id);
}