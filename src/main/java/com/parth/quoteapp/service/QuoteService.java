package com.parth.quoteapp.service;

import com.parth.quoteapp.dto.QuoteRequest;
import com.parth.quoteapp.entity.Quote;
import com.parth.quoteapp.exception.ResourceNotFoundException;
import com.parth.quoteapp.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAllQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            throw new ResourceNotFoundException("No quotes found");
        }
        return quotes;
    }

    public Quote createQuote(QuoteRequest request) {
        Quote quote = new Quote();
        quote.setText(request.getText());
        quote.setAuthor(request.getAuthor());
        return quoteRepository.save(quote);
    }

    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + id));
    }

    public Quote updateQuote(Long id, QuoteRequest request) {
        Quote existingQuote = quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + id));

        existingQuote.setText(request.getText());
        existingQuote.setAuthor(request.getAuthor());

        return quoteRepository.save(existingQuote);
    }

    public void deleteQuote(Long id) {
        Quote existingQuote = quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found with id: " + id));
        quoteRepository.delete(existingQuote);
    }
}
