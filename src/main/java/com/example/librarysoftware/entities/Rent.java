package com.example.librarysoftware.entities;

import java.util.Date;

public class Rent {
    private int code;
    private String userCpf;
    private String bookIsbn;
    private String rentInitDate;

    public Rent(String userCpf, String bookIsbn, String rentInitDate) {
        this.userCpf = userCpf;
        this.bookIsbn = bookIsbn;
        this.rentInitDate = rentInitDate;
    }

    public int getCode() {
        return code;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getRentInitDate() {
        return rentInitDate;
    }

    public void setRentInitDate(String rentInitDate) {
        this.rentInitDate = rentInitDate;
    }
}
