package org.rejeev.lms.controllers;

import org.rejeev.lms.model.User;
import org.rejeev.lms.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        user = UserRepository.create(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        user = UserRepository.update(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping
    public ResponseEntity<User> partialUpdate(@RequestBody User user){
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        User user = UserRepository.getById(id);
        if(user != null) return ResponseEntity.ok(user);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<User> getById(@PathVariable String userId){
        User user = UserRepository.getByUserId(userId);
        if(user != null) return ResponseEntity.ok(user);
        else return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String mobilePhone,
            @RequestParam(required = false) String locality,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String postCode
    ){
        if(firstName == null && lastName == null && email == null && phone == null &&
                mobilePhone == null && locality == null && region == null && country == null && postCode == null){
            return ResponseEntity.badRequest().build();
        }
        List<User> userList = UserRepository.findUsers(firstName, lastName, email, phone, mobilePhone, locality, region, country, postCode);
        return ResponseEntity.ok(userList);
    }
}
