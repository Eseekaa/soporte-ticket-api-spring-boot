package com.api.soporte_ticket_api_spring_boot.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketSoporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Asunto;  
    private String Estado; 
    

} 
  