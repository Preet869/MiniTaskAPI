package com.example.minitaskapi;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRespository extends JpaRepository<Task, Integer> {

}