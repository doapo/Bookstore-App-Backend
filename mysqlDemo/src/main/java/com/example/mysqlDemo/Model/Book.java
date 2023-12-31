package com.example.mysqlDemo.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;
    private String name;
    private String description;
    private double price;
    private String author;
    private String genre;
    private String publisher;
    private int year;
    private int copiesSold;
    private double rating;
    @OneToMany
    private List<BookRating> ratings;

    @OneToMany
    private List<BookComment> comments;


    public int getIsbn() {
        return isbn;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void addRating(BookRating bookRating)
    {
        ratings.add(bookRating);
        int temp = 0;
        for (BookRating r: ratings)
        {
            temp += r.getRating();
        }

        this.rating = (double) temp / (double)ratings.size();
    }

    public void addComment(BookComment bookComment)
    {
        comments.add(bookComment);
    }

    public List<BookComment> getComments()
    {
        return comments;
    }


}
