package com.usf.parking.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private int codigo;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Vaga vaga;

    @Column(name = "Entrada")
    private OffsetDateTime horaEntrada;

    @Column(name = "Saida")
    private OffsetDateTime horaSaida;

    @Enumerated(EnumType.STRING)
    private StatusTicket status;

}