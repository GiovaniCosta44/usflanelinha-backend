package com.usf.parking.api.controller;

import com.usf.parking.api.model.LoginModel;
import com.usf.parking.domain.model.Funcionario;
import com.usf.parking.domain.service.FuncionarioLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioLoginService funcionarioLoginService;

    @PostMapping("/login")
    public Funcionario login(@RequestBody LoginModel loginModel) throws Exception {
        try {
            System.out.println(loginModel.getEmail());
            return funcionarioLoginService.login(loginModel.getEmail(), loginModel.getPassword());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, (e.getMessage()));
        }
    }
}
