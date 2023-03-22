package com.example.demo.repository;

import com.example.demo.entity.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Integer> { }
