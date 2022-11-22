package com.usf.parking.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private int codigo;

    @NotNull
    @ManyToOne
    private Aluno aluno;

    @NotNull
    @ManyToOne
    private Vaga vaga;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "Entrada")
    private OffsetDateTime horaEntrada;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "Saida")
    private OffsetDateTime horaSaida;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusTicket status;

}