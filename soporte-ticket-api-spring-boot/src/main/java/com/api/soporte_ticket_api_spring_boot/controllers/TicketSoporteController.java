package com.api.soporte_ticket_api_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.soporte_ticket_api_spring_boot.dto.TicketSoporteDTO;
import com.api.soporte_ticket_api_spring_boot.services.TicketSoporteServices;

import java.util.List;

@RestController
@RequestMapping("/api/ticket-soporte")
public class TicketSoporteController {

    @Autowired
    private TicketSoporteServices ticketSoporteServices;

    @PostMapping
    public ResponseEntity<TicketSoporteDTO> crearTicket(@RequestBody TicketSoporteDTO ticketSoporteDTO) {
        TicketSoporteDTO creadoTicket = ticketSoporteServices.crearTicket(ticketSoporteDTO);
        return ResponseEntity.ok(creadoTicket);
    }

    @GetMapping
    public ResponseEntity<List<TicketSoporteDTO>> listarTickets() {
        List<TicketSoporteDTO> tickets = ticketSoporteServices.ListarTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSoporteDTO> buscarId(@PathVariable Integer id) {
        TicketSoporteDTO ticket = ticketSoporteServices.buscarId(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketSoporteDTO> actualizarTicket(@PathVariable Integer id, @RequestBody TicketSoporteDTO ticketSoporteDTO) {
        TicketSoporteDTO actualizadoTicket = ticketSoporteServices.actualizarTicket(id, ticketSoporteDTO);
        return ResponseEntity.ok(actualizadoTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Integer id) {
        ticketSoporteServices.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }
}
