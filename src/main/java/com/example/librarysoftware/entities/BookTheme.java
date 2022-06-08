package com.example.librarysoftware.entities;

public class BookTheme {
    private int themeCode;
    private String bookIsbn;

    public BookTheme(int themeCode, String bookIsbn) {
        this.themeCode = themeCode;
        this.bookIsbn = bookIsbn;
    }

    public int getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(int themeCode) {
        this.themeCode = themeCode;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }
}
