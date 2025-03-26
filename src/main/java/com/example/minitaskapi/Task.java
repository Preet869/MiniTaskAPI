package com.example.minitaskapi;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;


    public Task() {

    }

    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // get is used for returning the value of the variables
    public long getId() {
        return id;
    }
    //Set takes a parameter (id) and assigns it to the id variable.
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
