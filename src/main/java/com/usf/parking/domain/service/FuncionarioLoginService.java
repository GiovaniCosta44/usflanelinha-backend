package com.usf.parking.domain.service;

import com.usf.parking.domain.model.Funcionario;
import com.usf.parking.domain.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FuncionarioLoginService {

    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public Funcionario login(String email, String password) throws Exception {
        Funcionario funcionario = funcionarioRepository.findByEmail(email);
        if (funcionario != null && funcionario.getSenha().equals(password)) {
            return funcionario;
        } else {
            throw new Exception("User credencial invalid!");
        }

    }

}
