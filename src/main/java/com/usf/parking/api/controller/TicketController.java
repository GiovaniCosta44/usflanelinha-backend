package com.usf.parking.api.controller;

import com.usf.parking.domain.model.Vaga;
import com.usf.parking.domain.model.Ticket;
import com.usf.parking.domain.repository.TicketRepository;
import com.usf.parking.domain.service.GenerateTicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private GenerateTicketService generateTicketService;
    private TicketRepository ticketRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket generate(@RequestBody Ticket ticket)
    {
        return generateTicketService.generate(ticket);
    }

    @GetMapping
    public List<Ticket> listar()
    {
        return ticketRepository.findAll();

    }



}
