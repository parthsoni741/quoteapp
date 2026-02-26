package com.parth.quoteapp.config;

import com.parth.quoteapp.entity.Quote;
import com.parth.quoteapp.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(QuoteRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Quote("Stay hungry, stay foolish", "Steve Jobs"));
                repository.save(new Quote("Code is like humor. When you have to explain it, it’s bad.", "Cory House"));
            }
        };
    }
}
