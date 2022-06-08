package com.example.librarysoftware.entities;

public class User {
    private String cpf;
    private String email;
    private String address;
    private String name;

    public User(String cpf, String email, String address, String name) {
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
