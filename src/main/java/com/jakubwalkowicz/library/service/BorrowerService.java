package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.Borrower;

import java.util.List;
import java.util.Optional;

public interface BorrowerService {

    List<Borrower> findAll();

    Borrower add(Borrower borrower);

    Boolean delete(Long id);

    Borrower update(Borrower borrower, Long id);

    Optional<Borrower> findById(Long id);

}
