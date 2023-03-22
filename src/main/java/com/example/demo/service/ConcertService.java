package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.repository.ConcertRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    public Concert createConcert(Concert concert){
        return concertRepository.save(concert);
    }

    public void deleteConcertById(Integer id) {
        concertRepository.delete(concertRepository.findById(id).get());
    }

    public List<Concert> fetchConcerts(){
        return (List<Concert>) concertRepository.findAll();
    }

    public Concert updateConcert(Concert concert, Integer id) {
        Concert concertDB = concertRepository.findById(id).get();

        if(Objects.nonNull(concert.getNameConcert())
        && !"".equalsIgnoreCase(concert.getNameConcert())) {
            concertDB.setNameConcert(concert.getNameConcert());
        }

        if(Objects.nonNull(concert.getDateTimeConcert())
        && !"".equalsIgnoreCase(concert.getDateTimeConcert())) {
            concertDB.setDateTimeConcert(concert.getDateTimeConcert());
        }

        if(Objects.nonNull(concert.getNoTickets())
        && concert.getNoTickets() >= 0) {
            concertDB.setNoTickets(concert.getNoTickets());
        }

        if(Objects.nonNull(concert.getBandList())
        && concert.getBandList().size() > 0){
            concertDB.setBandList(concert.getBandList());
        }

        return concertRepository.save(concertDB);
    }

    public void updateNoTickets(Concert concert, Integer noTickets){

        concert.setNoTickets(concert.getNoTickets() - noTickets);

    }
}
