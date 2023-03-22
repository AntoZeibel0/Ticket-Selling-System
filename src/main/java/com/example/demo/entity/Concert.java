package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "concerts")
@SequenceGenerator(name = "idGen", initialValue = 6)
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "idGen")
    private Integer id;
    private String nameConcert;
    private Integer noTickets;
    private String dateTimeConcert;
    @ManyToMany
    private List<Band> bandList = new ArrayList<>();
}
