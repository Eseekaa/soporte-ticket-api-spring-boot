package com.api.soporte_ticket_api_spring_boot.dto;


import lombok.*;
@Data 

public class TicketSoporteDTO {
    
    private Integer ID_Ticket;
    private String Asunto;  
    private String Estado;
}
 