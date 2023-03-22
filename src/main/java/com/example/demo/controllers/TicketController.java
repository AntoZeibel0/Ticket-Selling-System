package com.example.demo.controllers;

import com.example.demo.csv.CSVTicket;
import com.example.demo.entity.Ticket;
import com.example.demo.service.ConcertService;
import com.example.demo.service.TicketService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
@EnableMethodSecurity
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CSVTicket csvTicket;

    @Autowired
    private ConcertService concertService;


    @GetMapping("/exportCSV")
    @PreAuthorize("hasAuthority('CASHIER')")
    public void exportCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        csvTicket.write(ticketService.fetchAllTickets(), response.getWriter());
    }

    @PostMapping("/createTicket")
    @PreAuthorize("hasAuthority('CASHIER')")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @DeleteMapping("/deleteTicket/{id}")
    @PreAuthorize("hasAuthority('CASHIER')")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Integer id){
        ticketService.deleteTicketById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateTicket/{id}")
    @PreAuthorize("hasAuthority('CASHIER')")
    public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("id") Integer id){
        return ticketService.updateTicket(ticket, id);
    }

    @GetMapping("/getTickets")
    @PreAuthorize("hasAuthority('CASHIER')")
    public @ResponseBody List<Ticket> getTickets(){
        return ticketService.fetchAllTickets();
    }
}
