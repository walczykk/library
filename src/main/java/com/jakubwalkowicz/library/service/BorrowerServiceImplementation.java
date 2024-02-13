package com.jakubwalkowicz.library.service;

import com.jakubwalkowicz.library.model.Borrower;
import com.jakubwalkowicz.library.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImplementation implements BorrowerService{

    private final BorrowerRepository borrowerRepository;

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower add(Borrower borrower) {
        if (borrower == null) {
            throw new IllegalStateException("Wrong input");
        }
        return borrowerRepository.save(borrower);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Borrower> borrowerOptional = borrowerRepository.findById(id);
        if (borrowerOptional.isEmpty()) {
            throw new IllegalStateException("No borrower of id: " + id + " was found");
        }
        borrowerRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public Borrower update(Borrower borrower, Long id) {
        return null;
    }

    @Override
    public Optional<Borrower> findById(Long id) {
        Optional<Borrower> borrowerOptional = borrowerRepository.findById(id);
        if (borrowerOptional.isEmpty()) {
            throw new IllegalStateException("No borrower of id: " + id + " was found");
        }
        return borrowerOptional;
    }

}
