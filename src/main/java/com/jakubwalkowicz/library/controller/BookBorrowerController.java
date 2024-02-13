package com.jakubwalkowicz.library.controller;

import com.jakubwalkowicz.library.model.BookBorrowerRel;
import com.jakubwalkowicz.library.service.BookBorrowerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/library/borrowings")
@RequiredArgsConstructor
public class BookBorrowerController {
    private final BookBorrowerService bookBorrowerService;

    @GetMapping("")
    public ResponseEntity<List<BookBorrowerRel>> findAll() {
        List<BookBorrowerRel> bookBorrowerRel = bookBorrowerService.findALl();
        return new ResponseEntity<>(bookBorrowerRel, OK);
    }
    @PostMapping("")
    public ResponseEntity<BookBorrowerRel> add(@RequestBody BookBorrowerRel bookBorrowerRel) {
        if (bookBorrowerRel == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<>(bookBorrowerService.add(bookBorrowerRel), OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable @Valid Long id) {
        Optional<BookBorrowerRel> bookBorrowerRelOptional = bookBorrowerService.findById(id);
        if (bookBorrowerRelOptional.isEmpty()) {
            log.warn("Relation of id: " + id + " doesn't exist");
        }
        bookBorrowerService.delete(id);
        return new ResponseEntity<>(Boolean.TRUE, OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookBorrowerRel> update(@RequestBody BookBorrowerRel bookBorrowerRel, @PathVariable @Valid Long id) {
        if (bookBorrowerRel == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        Optional<BookBorrowerRel> bookBorrowerRelOptional = bookBorrowerService.findById(id);
        if (bookBorrowerRelOptional.isEmpty()) {
            log.warn("Relation of id: " + id + " doesn't exist");
        }
            bookBorrowerService.update(bookBorrowerRel, id);
        return new ResponseEntity<>(bookBorrowerRel, OK);
    }
}
