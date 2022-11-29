package com.usf.parking.api.controller;

import com.usf.parking.domain.model.Funcionario;
import com.usf.parking.domain.model.LoginDto;
import com.usf.parking.domain.repository.FuncionarioRepository;
import com.usf.parking.domain.repository.LoginDtoRepository;
import com.usf.parking.domain.service.FuncionarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioLoginService funcionarioLoginService;
    private FuncionarioRepository funcionarioRepository;
    private LoginDtoRepository loginDtoRepository;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public LoginDto login(@RequestBody LoginDto loginDto)
    {
        return funcionarioLoginService.login(loginDto);
    }
}
