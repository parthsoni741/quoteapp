package com.parth.quoteapp;

import com.parth.quoteapp.model.Quote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService
{
    private final List<Quote> quotes = List.of(
            new Quote("Success is not final, failure is not fatal.", "Winston Churchill"),
            new Quote("The best way to predict the future is to invent it.", "Alan Kay"),
            new Quote("Stay hungry, stay foolish.", "Steve Jobs"),
            new Quote("First, solve the problem. Then, write the code.", "John Johnson")
    );

    private final Random random = new Random();

    public Quote getRandomQuote(){
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }
}
