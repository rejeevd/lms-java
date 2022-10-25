package org.rejeev.lms.controllers;

import org.rejeev.lms.model.Book;
import org.rejeev.lms.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        book = BookRepository.create(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book){
        book = BookRepository.update(book);
        return ResponseEntity.ok(book);
    }

    @PatchMapping
    public ResponseEntity<Book> partialUpdate(@RequestBody Book book){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id){
        Book book = BookRepository.getById(id);
        if(book != null) return ResponseEntity.ok(book);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> search(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String content
    ){
        List<Book> bookList = new ArrayList<>();
        return ResponseEntity.ok(bookList);
    }
}
