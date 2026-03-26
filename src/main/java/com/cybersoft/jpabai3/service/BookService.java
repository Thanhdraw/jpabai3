package com.cybersoft.jpabai3.service;


import com.cybersoft.jpabai3.entity.book.BookEntity;
import com.cybersoft.jpabai3.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookEntity> search(String author, BigDecimal minPrice, BigDecimal maxPrice) {

        Specification<BookEntity> spec = (root, query, cb) -> cb.conjunction();

        if (author != null && !author.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get("author"), "%" + author + "%"));
        }

        if (minPrice != null) {
            spec = spec.and((root, query, cb) ->
                    cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and((root, query, cb) ->
                    cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        }


        return bookRepository.findAll(spec);
    }
}
