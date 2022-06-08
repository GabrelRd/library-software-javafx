package com.example.librarysoftware.entities;

import java.util.Date;

public class Author {
    private int id;
    private String name;
    private String yearBirth;
    private String description;

    public Author(String name, String yearBirth, String description) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
