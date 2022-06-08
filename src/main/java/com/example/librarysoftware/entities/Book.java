package com.example.librarysoftware.entities;


public class Book {
    private String isbn;
    private String name;
    private int quantity;
    private String releaseYear;
    private String edition;
    private int publishingID;
    private int authorID;

    public Book(String isbn, String name, int quantity, String releaseYear, String edition, int publishingID, int authorID) {
        this.isbn = isbn;
        this.name = name;
        this.quantity = quantity;
        this.releaseYear = releaseYear;
        this.edition = edition;
        this.publishingID = publishingID;
        this.authorID = authorID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPublishingID() {
        return publishingID;
    }

    public void setPublishingID(int publishingID) {
        this.publishingID = publishingID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
