package org.rejeev.lms.controllers;

import org.rejeev.lms.model.Author;
import org.rejeev.lms.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author){
        logger.info("Author: " + author.toString());
        author = AuthorRepository.create(author);
        return ResponseEntity.ok(author);
    }

    @PutMapping
    public ResponseEntity<Author> update(@RequestBody Author author){
        author = AuthorRepository.update(author);
        return ResponseEntity.ok(author);
    }

    @PatchMapping
    public ResponseEntity<Author> partialUpdate(@RequestBody Author author){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable int id){
        Author author = AuthorRepository.getById(id);
        if(author != null) return ResponseEntity.ok(author);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Author>> search(
            @RequestParam String firstName,
            @RequestParam String lastName
    ){
        List<Author> authorList = new ArrayList<>();
        return ResponseEntity.ok(authorList);
    }
}
