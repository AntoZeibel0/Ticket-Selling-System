package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bands")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String genre;
    private String nameBand;
    @ManyToMany
    private List<Concert> concertList = new ArrayList<>();

}
