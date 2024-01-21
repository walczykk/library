package com.booklibrary.booklibrary.service;

import com.booklibrary.booklibrary.model.Author;
import com.booklibrary.booklibrary.repository.AuthorRepository;
import jakarta.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.lang.Boolean.*;

@Service
public class AuthorServiceImplementation implements AuthorService{

    private final AuthorRepository authorRepository;
    private final Validator validator;

    @Autowired
    public AuthorServiceImplementation(AuthorRepository authorRepository, Validator validator) {this.authorRepository = authorRepository;
        this.validator = validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findAllAuthors() {
       return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> findAuthorById(Long id) {

        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isEmpty()) {
            throw new IllegalStateException("No author of id: " + id + " was found");
        }
        return authorOptional;
    }
    @Override
    public Author addAuthor(Author author) {

        if (author == null) {
            throw new IllegalStateException("Wrong input");
        }

        return authorRepository.save(author);
    }
    @Transactional
    @Override
    public Boolean deleteAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isEmpty()) {
            throw new IllegalStateException("Author with id: " + id + " was not found");
        }
        authorRepository.deleteById(id);
        return TRUE;
    }
    @Transactional
    @Override
    public Author updateAuthor(Author author, Long id) {

        Optional<Author> existingAuthorOptional = authorRepository.findById(id);

        if (authorRepository.findById(id).isEmpty()) {
            throw new IllegalStateException("Author with id: " + id + " was not found");
        }
        else if (author == null) {
            throw new IllegalStateException("Wrong input");
        }
        Author existingAuthor = existingAuthorOptional.get();
        existingAuthor = author;
        return authorRepository.save(author);
    }
}
