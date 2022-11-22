package com.usf.parking.api.controller;

import com.usf.parking.domain.model.Aluno;
import com.usf.parking.domain.model.Vaga;
import com.usf.parking.domain.model.Ticket;
import com.usf.parking.domain.repository.TicketRepository;
import com.usf.parking.domain.service.FinishTicketService;
import com.usf.parking.domain.service.GenerateTicketService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private GenerateTicketService generateTicketService;
    private TicketRepository ticketRepository;
    private FinishTicketService finishTicketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket generate(@Valid @RequestBody Ticket ticket) {
        return generateTicketService.generate(ticket);
    }

    @GetMapping
    public List<Ticket> listar()
    {
        return ticketRepository.findAll();
    }

    @GetMapping("/{ticketId}")
    public Ticket buscar (@PathVariable Integer ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);

        return ticket.orElse(null);
    }

    @PutMapping("/{ticketId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizacao(@PathVariable Integer ticketId){
        finishTicketService.finish(ticketId);
    }

}
