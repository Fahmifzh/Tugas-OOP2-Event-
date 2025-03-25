/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Fahmi Fauziah
 */
public class Event {
    private int id;
    private String title;
    private String description;
    private int categoryId;
    private boolean isCompleted;
    private String createdAt;

    public Event(int id, String title, String description, int categoryId, boolean isCompleted, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    public Event(String title, String description, int categoryId) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.isCompleted = false;
    }

    // Getters dan Setters
    public int getId() { 
        return id;
    }
    public String getTitle() { 
        return title;
    }
    public void setTitle(String title) { 
        this.title = title;
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public int getCategoryId() { 
        return categoryId; 
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId; 
    }
    public boolean isCompleted() { 
        return isCompleted;
    }
    public void setCompleted(boolean completed) {
        isCompleted = completed; 
    }
    public String getCreatedAt() {
        return createdAt; 
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", isCompleted=" + isCompleted +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
