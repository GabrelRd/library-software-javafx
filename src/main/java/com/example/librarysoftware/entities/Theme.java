package com.example.librarysoftware.entities;

public class Theme {
    private int code;
    private String name;
    private String description;

    public Theme(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
