package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.Author;
import com.jakubwalkowicz.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            throw new IllegalStateException("No author of id: " + id + " was found");
        }
        return authorOptional;
    }

    @Override
    public Author add(Author author) {
        if (author == null) {
            throw new IllegalStateException("Wrong input");
        }
        return authorRepository.save(author);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            throw new IllegalStateException("No author with id: " + id + " was found");
        }
        authorRepository.deleteById(id);
        return TRUE;
    }

    @Transactional
    @Override
    public Author update(Author author, Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            throw new IllegalStateException("No author with id: " + id + " was found");
        }
        if (author == null) {
            throw new IllegalStateException("Wrong input");
        }
        Author existingAuthor = authorOptional.get();
        existingAuthor.setName(author.getName());
        existingAuthor.setSurname(author.getSurname());
        existingAuthor.setDateOfBirth(author.getDateOfBirth());
        return authorRepository.save(existingAuthor);
    }
}
