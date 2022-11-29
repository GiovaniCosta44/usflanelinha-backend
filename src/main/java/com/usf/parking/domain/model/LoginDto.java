package com.usf.parking.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class LoginDto {

    @Id
    private int rf;

    private String senha;

    public LoginDto() {

    }
}

