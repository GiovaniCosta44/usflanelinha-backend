package com.usf.parking.domain.repository;

import com.usf.parking.domain.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {

    List<Vaga> findByStatus(Integer status);

}
