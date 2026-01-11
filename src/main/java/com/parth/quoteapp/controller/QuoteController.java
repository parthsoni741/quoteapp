package com.parth.quoteapp.controller;

import com.parth.quoteapp.QuoteService;
import com.parth.quoteapp.model.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }
    @GetMapping("/api/quotes")
    public Quote getRandomQuote(){
        return quoteService.getRandomQuote();
    }
}
