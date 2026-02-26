package com.parth.quoteapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String author;

    //  Required by JPA
    public Quote() {
    }

    public Quote(String text) {
        this.text = text;
    }

    //  Convenience constructor (used in services/controllers)
    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    // ----- Getters & Setters -----

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
