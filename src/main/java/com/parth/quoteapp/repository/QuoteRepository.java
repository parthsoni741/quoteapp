package com.parth.quoteapp.repository;

import com.parth.quoteapp.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
