package com.parth.quoteapp.dto;
import jakarta.validation.constraints.NotBlank;

public class QuoteRequest {
    @NotBlank(message = "Text must not be blank")
    private String text;

    @NotBlank(message = "Author must not be blank")
    private String author;

    public QuoteRequest() {}

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
