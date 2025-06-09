package com.api.soporte_ticket_api_spring_boot.repository;

import org.springframework.stereotype.Repository;

import com.api.soporte_ticket_api_spring_boot.models.TicketSoporte;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface TicketSoporteRepository extends JpaRepository <TicketSoporte, Integer>{ 

}
