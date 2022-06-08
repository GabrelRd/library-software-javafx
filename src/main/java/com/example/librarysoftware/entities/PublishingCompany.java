package com.example.librarysoftware.entities;

public class PublishingCompany {
    private int code;
    private String name;
    private String initials;

    public PublishingCompany(String name, String initials) {
        this.name = name;
        this.initials = initials;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
