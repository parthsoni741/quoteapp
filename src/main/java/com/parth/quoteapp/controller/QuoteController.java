package com.parth.quoteapp.controller;

import com.parth.quoteapp.model.Quote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    @GetMapping("/api/quotes")
    public Quote getQuote(){
        return new Quote(
                "Success is not final, failure is not fatal: It is the courage to continue that counts.",
                "Winston Churchill");
    }
}
