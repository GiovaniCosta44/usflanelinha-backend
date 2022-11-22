package com.usf.parking.api.controller;

import com.usf.parking.domain.model.Aluno;
import com.usf.parking.domain.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AlunoController {

    private AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    public List<Aluno> listar () {
        return alunoRepository.findAll();
    }

    @GetMapping("/alunos/{alunoRa}")
    public Aluno buscar(@PathVariable Integer alunoRa){
        Optional<Aluno> aluno = alunoRepository.findById(alunoRa);

        return aluno.orElse(null);
    }

}
