package com.example.model;

public class Book {
    private int _id;
    private String  _title;
    private String _author;
    private int _year;
    private int _pages;

    public Book(int id, String title, String author, int year, int pages) {
        this._id = id;
        this._title = title;
        this._author = author;
        this._year = year;
        this._pages = pages;
    }

    public int getId() {
        return _id;
    }
    
    public void setId(int id) {
        this._id = id;
    }

    public String getTitle() {
        return _title;
    }   
    
    public void setTitle(String title) {
        this._title = title;
    }   

    public String getAuthor() {
        return _author;
    }
    
    public void setAuthor(String author) {
        this._author = author;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        this._year = year;
    }

    public int getPages() {
        return _pages;
    }   

    public void setPages(int pages) {
        this._pages = pages;
    }

    
}
