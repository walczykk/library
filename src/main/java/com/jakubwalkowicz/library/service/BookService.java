package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book add(Book book);
    Book update(Book book, Long id);
    Boolean delete(Long id);
}
