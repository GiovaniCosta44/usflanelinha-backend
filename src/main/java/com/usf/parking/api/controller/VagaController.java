package com.usf.parking.api.controller;

import com.usf.parking.domain.model.Vaga;
import com.usf.parking.domain.repository.VagaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VagaController {


    private VagaRepository vagaRepository;

    @GetMapping("/vagas")
    public List<Vaga> buscarVagasLivres() {
        return vagaRepository.findByStatus(1);
    }

}
