package com.example.demo.csv;

import com.example.demo.entity.Ticket;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CSVTicket {
    public void write(List<Ticket> ticketList, Writer writer) throws IOException {
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        for(Ticket t : ticketList) {
            printer.printRecord("Ticket:", t.getId(),
                    "Price:", t.getPrice() * t.getPlaces(),
                    "Number of places:", t.getPlaces());
        }
    }
}
