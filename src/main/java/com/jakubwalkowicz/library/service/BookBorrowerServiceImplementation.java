package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.BookBorrowerRel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class BookBorrowerServiceImplementation implements BookBorrowerService {
    private final BookBorrowerServiceImplementation bookBorrowerServiceImplementation;

    @Override
    public List<BookBorrowerRel> findALl() {
        return bookBorrowerServiceImplementation.findALl();
    }

    @Override
    public BookBorrowerRel add(BookBorrowerRel bookBorrowerRel) {
        if (bookBorrowerRel == null) {
            throw new IllegalStateException("Wrong input");
        }
        return bookBorrowerServiceImplementation.add(bookBorrowerRel);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<BookBorrowerRel> bookBorrowerRelOptional = bookBorrowerServiceImplementation.findById(id);
        if (bookBorrowerRelOptional.isEmpty()) {
            throw new IllegalStateException("No relation of id: " + id + " was found");
        }
        bookBorrowerServiceImplementation.delete(id);
        return TRUE;
    }

    @Override
    public BookBorrowerRel update(BookBorrowerRel bookBorrowerRel, Long id) {
        if (bookBorrowerRel == null) {
            throw new IllegalStateException("Wrong input");
        }
        Optional<BookBorrowerRel> bookBorrowerRelOptional = bookBorrowerServiceImplementation.findById(id);
        if (bookBorrowerRelOptional.isEmpty()) {
            throw new IllegalStateException("No relation of id: " + id + " was found");
        }
        return bookBorrowerServiceImplementation.update(bookBorrowerRel, id);
    }

    @Override
    public Optional<BookBorrowerRel> findById(Long id) {
        Optional<BookBorrowerRel> bookBorrowerRelOptional = bookBorrowerServiceImplementation.findById(id);
        if (bookBorrowerRelOptional.isEmpty()) {
            throw new IllegalStateException("No relation of id: " + id + " was found");
        }
        return bookBorrowerServiceImplementation.findById(id);
    }
}
