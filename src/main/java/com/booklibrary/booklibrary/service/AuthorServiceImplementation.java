package com.booklibrary.booklibrary.service;

import com.booklibrary.booklibrary.model.Author;
import com.booklibrary.booklibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImplementation implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository) {this.authorRepository = authorRepository;}


    @Override
    public List<Author> findAllAuthors() {
       return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthorById(Long id) {

        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            return authorOptional;
        }
        else throw new IllegalStateException("No")

        return
    }

    @Override
    public Author addAuthor(Author author) {
        return null;
    }

    @Override
    public Boolean deleteAuthor(Long id) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        return null;
    }
}
