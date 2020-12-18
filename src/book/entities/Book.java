/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.entities;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Book {
    private String id;
    private String title;
    private String author;
    private String publishing;
    private int year;
    private float price;
    private LocalDate dateType;

    public Book() {
    }

    public Book(String id, String title, String author, String publishing, int year, float price, LocalDate dateType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.price = price;
        this.dateType = dateType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDateType() {
        return dateType;
    }

    public void setDateType(LocalDate dateType) {
        this.dateType = dateType;
    }

    @Override
    public String toString() {
        return this.title;
    }
    
    
}
