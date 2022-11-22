package com.usf.parking.domain.repository;

import com.usf.parking.domain.model.Aluno;
import com.usf.parking.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByCodigo(Integer codigo);

}
