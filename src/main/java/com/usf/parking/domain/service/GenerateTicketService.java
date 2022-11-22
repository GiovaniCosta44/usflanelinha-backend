package com.usf.parking.domain.service;

import com.usf.parking.domain.model.Aluno;
import com.usf.parking.domain.model.StatusTicket;
import com.usf.parking.domain.model.Ticket;
import com.usf.parking.domain.model.Vaga;
import com.usf.parking.domain.repository.AlunoRepository;
import com.usf.parking.domain.repository.TicketRepository;
import com.usf.parking.domain.repository.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class GenerateTicketService {

    private TicketRepository ticketRepository;
    private AlunoRepository alunoRepository;
    private VagaRepository vagaRepository;

    @Transactional
    public Ticket generate(Ticket ticket){
        Aluno aluno = alunoRepository.findById(ticket.getAluno().getRa())
                .orElseThrow();
        Vaga vaga = vagaRepository.findById(ticket.getVaga().getId())
                .orElseThrow();

        vaga.setStatus(2);
        ticket.setVaga(vaga);
        ticket.setAluno(aluno);
        ticket.setStatus(StatusTicket.ATIVO);
        ticket.setHoraEntrada(OffsetDateTime.now());
        return ticketRepository.save(ticket);

    }
}
