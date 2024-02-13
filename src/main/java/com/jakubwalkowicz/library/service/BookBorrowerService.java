package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.BookBorrowerRel;

import java.util.List;
import java.util.Optional;

public interface BookBorrowerService {
    List<BookBorrowerRel> findALl();
    BookBorrowerRel add(BookBorrowerRel bookBorrowerRel);
    Boolean delete(Long id);
    BookBorrowerRel update(BookBorrowerRel bookBorrowerRel, Long id);
    Optional<BookBorrowerRel> findById(Long id);
}
