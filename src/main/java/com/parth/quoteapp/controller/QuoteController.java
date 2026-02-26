package com.parth.quoteapp.controller;

import com.parth.quoteapp.api.ApiResponse;
import com.parth.quoteapp.dto.QuoteRequest;
import com.parth.quoteapp.entity.Quote;
import com.parth.quoteapp.service.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public ApiResponse<List<Quote>> getAllQuotes() {
        return ApiResponse.success(quoteService.getAllQuotes());
    }
    
    @GetMapping("/{id}")
    public ApiResponse<Quote> getQuoteById(@PathVariable Long id) {
        return ApiResponse.success(quoteService.getQuoteById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Quote>> createQuote(@Valid @RequestBody QuoteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(quoteService.createQuote(request)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long id, @Valid @RequestBody QuoteRequest request) {
        Quote updatedQuote = quoteService.updateQuote(id, request);
        return ResponseEntity.ok(updatedQuote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }



}
