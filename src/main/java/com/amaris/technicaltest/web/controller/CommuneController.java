package com.amaris.technicaltest.web.controller;

import com.amaris.technicaltest.persistence.entity.CommuneEntity;
import com.amaris.technicaltest.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/communes", produces = "application/json")
public class CommuneController {

    private final CommuneService communeService;

    @Autowired
    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    @GetMapping
    public ResponseEntity<List<CommuneEntity>> getAll() {
        return ResponseEntity.ok(this.communeService.getAll());
    }
}
