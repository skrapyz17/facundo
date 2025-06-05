package org.pacifico.controller.dto;

import org.pacifico.entity.bean.Cliente;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ClienteConHistoriaRequest {
    
    @Valid 
    private Cliente cliente;
    

    private String diagnostico;
    
}
