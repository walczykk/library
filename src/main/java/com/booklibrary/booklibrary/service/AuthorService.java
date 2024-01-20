package com.booklibrary.booklibrary.service;
import com.booklibrary.booklibrary.model.Author;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

    List<Author> findAllAuthors();

    Optional<Author> findAuthorById(Long id);

    Author addAuthor(Author author);

    Boolean deleteAuthor(Long id);

    Author updateAuthor(Author author, Long id);
}
