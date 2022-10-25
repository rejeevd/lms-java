package org.rejeev.lms.controllers;

import org.rejeev.lms.model.Book;
import org.rejeev.lms.model.Lease;
import org.springframework.http.ResponseEntity;

public class LeaseController {
    public ResponseEntity<Lease> borrow(Integer bookId, Integer userId){
        return null;
    }

    public ResponseEntity<Lease> renew(){
        return null;
    }
}
