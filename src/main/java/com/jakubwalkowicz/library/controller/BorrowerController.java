package com.jakubwalkowicz.library.controller;

import com.jakubwalkowicz.library.model.Borrower;
import com.jakubwalkowicz.library.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/library/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    @GetMapping("")
    public ResponseEntity<List<Borrower>> findAll() {
        List<Borrower> borrowers = borrowerService.findAll();
        return new ResponseEntity<>(borrowers, OK);
    }

    @PostMapping("")
    public ResponseEntity<Borrower> add(@RequestBody Borrower borrower) {
        if (borrower == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<>(borrower, OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> update(@RequestBody Borrower borrower, @PathVariable Long id) {
        Optional<Borrower> borrowerOptional = borrowerService.findById(id);
        if (borrowerOptional.isEmpty()) {
            log.warn("No borrower of id: " + id + " was found");
            return new ResponseEntity<>(NOT_FOUND);
        }
        if (borrower == null) {
            log.warn("Wrong input");
            return new ResponseEntity<>(BAD_REQUEST);
        }
        borrowerService.update(borrower, id);
        return new ResponseEntity<>(borrower, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Optional<Borrower> borrowerOptional = borrowerService.findById(id);
        if (borrowerOptional.isEmpty()) {
            log.warn("No borrower of id: " + id + " was found");
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(borrowerService.delete(id), OK);
    }

}
