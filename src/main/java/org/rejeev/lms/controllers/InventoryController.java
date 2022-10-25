package org.rejeev.lms.controllers;

import org.rejeev.lms.model.BookInventory;
import org.rejeev.lms.repositories.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @PostMapping
    public ResponseEntity<BookInventory> create(@RequestBody BookInventory inventory){
        inventory = InventoryRepository.create(inventory);
        return ResponseEntity.ok(inventory);
    }

    @PutMapping
    public ResponseEntity<BookInventory> update(@RequestBody BookInventory inventory){
        inventory = InventoryRepository.update(inventory);
        return ResponseEntity.ok(inventory);
    }

    @PatchMapping
    public ResponseEntity<BookInventory> partialUpdate(@RequestBody BookInventory inventory){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookInventory> getById(@PathVariable int id){
        BookInventory book = InventoryRepository.getById(id);
        if(book != null) return ResponseEntity.ok(book);
        else return ResponseEntity.notFound().build();
    }
}
