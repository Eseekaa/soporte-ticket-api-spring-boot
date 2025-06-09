package com.api.soporte_ticket_api_spring_boot.services;

import com.api.soporte_ticket_api_spring_boot.models.TicketSoporte;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.soporte_ticket_api_spring_boot.dto.TicketSoporteDTO;
import com.api.soporte_ticket_api_spring_boot.repository.TicketSoporteRepository;

@Service

public class TicketSoporteServices {
    @Autowired
    private TicketSoporteRepository tSR;

    private TicketSoporte toEntity (TicketSoporteDTO ticketSoporteDTO)
    {
        TicketSoporte ticketSoporte = new TicketSoporte();
        ticketSoporte.setID(ticketSoporteDTO.getID_Ticket());
        ticketSoporte.setAsunto(ticketSoporteDTO.getAsunto());
        ticketSoporte.setEstado(ticketSoporteDTO.getEstado());
        return ticketSoporte;
    }

    private TicketSoporteDTO toDTO (TicketSoporte ticketSoporte)
    {
        TicketSoporteDTO ticketSoporteDTO = new TicketSoporteDTO();
        ticketSoporteDTO.setID_Ticket(ticketSoporte.getID());
        ticketSoporteDTO.setAsunto(ticketSoporte.getAsunto());
        ticketSoporteDTO.setEstado(ticketSoporte.getEstado());
        return ticketSoporteDTO;
    }  
    public TicketSoporteDTO crearTicket(TicketSoporteDTO ticketSoporteDTO) {
        TicketSoporte ticketSoporte = toEntity(ticketSoporteDTO);
        TicketSoporte savedTicket = tSR.save(ticketSoporte);
        return toDTO(savedTicket);
    }

    public List<TicketSoporteDTO> ListarTickets() {
        return tSR.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    
        
    public TicketSoporteDTO buscarId(Integer id) 
    {
    TicketSoporte ticketSoporte = tSR.findById(id)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado: " + id));
    return toDTO(ticketSoporte);
    }
    
    public TicketSoporteDTO actualizarTicket(Integer id, TicketSoporteDTO Dto) { 
    TicketSoporte existTicket = tSR.findById(id) 
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado: " + id)); 
    existTicket.setAsunto(Dto.getAsunto());
    existTicket.setEstado(Dto.getEstado());
    TicketSoporte Ticket_actualizado = tSR.save(existTicket);
    return toDTO(Ticket_actualizado);
 }
 public void eliminarTicket(Integer id)
  {
    TicketSoporte ticketSoporte = tSR.findById(id)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado: " + id));
    tSR.delete(ticketSoporte);

 }
} 