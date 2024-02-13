package com.jakubwalkowicz.library.repository;

import com.jakubwalkowicz.library.model.BookBorrowerRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrowerRelRepository extends JpaRepository<BookBorrowerRel, Long> {
}
