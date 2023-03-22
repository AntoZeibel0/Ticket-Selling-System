package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Role;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
public class ServiceTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void testUser() {
        User user = new User(1001,
                "antonica",
                "prajiturica",
                Role.CASHIER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        assertTrue(passwordEncoder.matches("prajiturica", user.getPassword()));
    }

//    @Test
//    void testTickets() {
//        Concert concert = new Concert(1001, "test", 100, "10 mai", null);
//        Ticket ticket = new Ticket(1001, 10.0, 1001, 200);
//
//    }
}
