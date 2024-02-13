package com.jakubwalkowicz.library.service;
import com.jakubwalkowicz.library.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Author add(Author author);
    Boolean delete(Long id);
    Author update(Author author, Long id);
}
