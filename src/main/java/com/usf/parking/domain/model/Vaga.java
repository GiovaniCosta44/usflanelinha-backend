package com.usf.parking.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Numero")
    private int numero;

    @Column(name = "Rua")
    private int Rua;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Status")
    private int status;
}
