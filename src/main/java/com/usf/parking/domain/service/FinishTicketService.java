package com.usf.parking.domain.service;


import com.usf.parking.domain.model.StatusTicket;
import com.usf.parking.domain.model.Ticket;
import com.usf.parking.domain.model.Vaga;
import com.usf.parking.domain.repository.TicketRepository;
import com.usf.parking.domain.repository.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class FinishTicketService {

    private TicketRepository ticketRepository;
    private VagaRepository vagaRepository;

    @Transactional
    public void finish(Integer ticketId){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow();
        Vaga vaga = vagaRepository.findById(ticket.getVaga().getId())
                .orElseThrow();

        if (ticket.getStatus().equals(StatusTicket.ATIVO)) {
            ticket.setStatus(StatusTicket.FINALIZADO);
            ticket.setHoraSaida(OffsetDateTime.now());
            vaga.setStatus(1);
        }

    }

}
