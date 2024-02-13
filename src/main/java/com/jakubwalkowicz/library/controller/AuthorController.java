package com.jakubwalkowicz.library.controller;

import com.jakubwalkowicz.library.model.Author;
import com.jakubwalkowicz.library.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequestMapping("/library/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<List<Author>> findALl() {
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, OK);
    }

    @PostMapping("")
    public ResponseEntity<Author> add(@RequestBody @Valid Author author) {
        if (author == null) {
            log.warn("Wrong author properties provided");
        }
        authorService.add(author);
        if (author != null) {
            log.info("Author with id: " + author.getId() + " was saved");
        }
        return new ResponseEntity<>(author, CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@Valid @RequestBody Author author, @PathVariable Long id) {
        if (author == null){
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<Author> authorOptional = authorService.findById(id);
        if (authorOptional.isEmpty()) {
            log.warn("Author of id: " + id + " doesn't exist");
            return new ResponseEntity<>(NOT_FOUND);
        }
        authorService.update(author, id);
        return new ResponseEntity<>(author, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Optional<Author> authorOptional = authorService.findById(id);
        if (authorOptional.isEmpty()) {
            log.warn("Author of id: " + id + " doesn't exist");
            return new ResponseEntity<>(FALSE, BAD_REQUEST);
        }
        authorService.delete(id);
        return new ResponseEntity<>(TRUE, OK);
    }
}
