package com.amaris.technicaltest.web.controller;

import com.amaris.technicaltest.persistence.entity.UserEntity;
import com.amaris.technicaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable int id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> add(@RequestBody UserEntity user) {
        if (user.getId() == null || !this.userService.exist(user.getId())) {
            return ResponseEntity.ok(this.userService.save(user));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity user) {
        if (user.getId() != null && this.userService.exist(user.getId())) {
            return ResponseEntity.ok(this.userService.save(user));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (this.userService.exist(id)) {
            this.userService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
