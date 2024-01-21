package com.booklibrary.booklibrary.controller;

import com.booklibrary.booklibrary.model.Author;
import com.booklibrary.booklibrary.service.AuthorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Controller
@Slf4j
@RequestMapping("/library/books/authors")
public class AuthorController {

    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Author>> findAllAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        return new ResponseEntity<>(authors, OK);
    }

    @PostMapping("")
    public ResponseEntity<Author> addAuthor(@RequestBody @Valid Author author) {

        authorService.addAuthor(author);
        log.info("Author with id: " + author.getId() + " was saved");
        return new ResponseEntity<>(author, OK);
    }

}
