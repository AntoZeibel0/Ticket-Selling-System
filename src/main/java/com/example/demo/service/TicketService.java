package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Ticket;
import com.example.demo.repository.ConcertRepository;
import com.example.demo.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ConcertRepository concertRepository;

    public Ticket createTicket(Ticket ticket) {
        Concert concert = concertRepository.findById(ticket.getConcertId()).get();
        if (concert.getNoTickets() - ticket.getPlaces() > 0) {
            concert.setNoTickets(concert.getNoTickets() - ticket.getPlaces());
            concertRepository.save(concert);

            return ticketRepository.save(ticket);
        } else {
            log.info("Could not create ticket with ID: {} into the database", ticket.getId());
            return null;
        }
    }

    public List<Ticket> fetchAllTickets() {
        return ticketRepository.findAll();
    }

    public void deleteTicketById(Integer id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        Concert concert = concertRepository.findById(ticket.getConcertId()).orElseThrow();
        concert.setNoTickets(concert.getNoTickets() + ticket.getPlaces());
        concertRepository.save(concert);
        ticketRepository.deleteById(id);
    }

    public Ticket updateTicket(Ticket ticket, Integer id) {

        Ticket ticketDB = ticketRepository.findById(id).get();

        if (Objects.nonNull(ticket.getId())) {
            if (Objects.nonNull(ticket.getPlaces())
                    && ticket.getPlaces() > 0) {
                ticketDB.setPlaces(ticket.getPlaces());
            }

            if (Objects.nonNull(ticket.getPrice())
                    && ticket.getPrice() > 0) {
                ticketDB.setPrice(ticket.getPrice());
            }

            if (Objects.nonNull(ticket.getConcertId())
                    && concertRepository.existsById(ticket.getConcertId())) {
                ticketDB.setConcertId(ticket.getConcertId());
            }

        }
        return ticketRepository.save(ticketDB);
    }
}
