package com.usf.parking.domain.repository;

import com.usf.parking.domain.model.LoginDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDtoRepository extends JpaRepository<LoginDto, Integer> {
}
