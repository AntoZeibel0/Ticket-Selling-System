package com.example.demo.controllers;

import com.example.demo.entity.Concert;
import com.example.demo.service.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concert")
@EnableMethodSecurity
public class ConcertController {

    @Autowired
    ConcertService concertService;

    @GetMapping("/getConcerts")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Concert>> getConcerts(){
        return ResponseEntity.ok().body(concertService.fetchConcerts());
    }

    @PostMapping("/createConcert")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Concert createConcert(@RequestBody Concert concert) {
        return concertService.createConcert(concert);
    }

    @DeleteMapping("/deleteConcert/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>deleteConcert(@PathVariable("id") Integer id){
        concertService.deleteConcertById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateConcert/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Concert updateConcert(@RequestBody Concert concert , @PathVariable("id") Integer id){
        return concertService.updateConcert(concert,id);
    }

}
