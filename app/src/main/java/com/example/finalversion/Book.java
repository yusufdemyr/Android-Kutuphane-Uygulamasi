package com.example.finalversion;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private byte[] cover;

    public Book(int id, String title, String author, String description, byte[] cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;

        this.cover = cover;
    }

    // Getter metotları
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getDescription(){
        return description;
    }
    public byte[] getCover() {
        return cover;
    }

    // Setter metotları
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}
