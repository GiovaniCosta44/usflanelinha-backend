package com.usf.parking.domain.service;

import com.usf.parking.domain.model.Funcionario;
import com.usf.parking.domain.model.LoginDto;
import com.usf.parking.domain.repository.FuncionarioRepository;
import com.usf.parking.domain.repository.LoginDtoRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FuncionarioLoginService {

    private FuncionarioRepository funcionarioRepository;
    private LoginDtoRepository loginDtoRepository;

    @Transactional
    public LoginDto login(LoginDto loginDto) {
        Funcionario funcionario = funcionarioRepository.findById(loginDto.getRf())
                .orElseThrow();

        if(loginDto.getRf() == funcionario.getRf() && loginDto.getSenha()
                .equals(funcionario.getSenha()) ) {

        }
        return loginDto;
    }

}
