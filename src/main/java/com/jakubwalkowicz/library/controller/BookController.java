package com.jakubwalkowicz.library.controller;

import com.jakubwalkowicz.library.model.Author;
import com.jakubwalkowicz.library.model.Book;
import com.jakubwalkowicz.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/library/books")
@RequiredArgsConstructor
public class BookController {

    public final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> findALl() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isEmpty()) {
            log.warn("Book of id: " + id + " doesn't exist");
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(bookOptional.get(), OK);
    }

    @PostMapping("")
    public ResponseEntity<Book> add(@RequestBody @Valid Book book) {
        if (book == null) {
            log.warn("Wrong book properties provided");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        bookService.add(book);
        return new ResponseEntity<>(book, OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody @Valid Book book, @PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isEmpty()) {
            log.warn("Book of id: " + id + " doesn't exist");
            return new ResponseEntity<>(NOT_FOUND);
        }
        if (book == null) {
            log.warn("Wrong book properties provided");
        }
        bookService.update(book, id);
        return new ResponseEntity<>(book, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isEmpty()) {
            log.warn("Book of id: " + id + " doesn't exist");
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(bookService.delete(id), OK);
    }

}
