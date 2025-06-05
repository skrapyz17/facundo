package org.pacifico.controller;


import org.pacifico.controller.dto.ClienteConHistoriaRequest;
import org.pacifico.entity.bean.Cliente;
import org.pacifico.usecase.ClienteUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.Data;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;


    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @GetMapping("/diagnosticos")
    public List<Object[]> getDiagnosticosDesdeFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return clienteUseCase.obtenerDiagnosticosClientesDesdeFecha(fecha);
    }

    @GetMapping("/apellido-a")
    public List<Cliente> getClientesConApellidoA() {
        return clienteUseCase.obtenerClientesConApellidoA();
    }
    @PostMapping
    public ResponseEntity<Cliente> registrarClienteConHistoria(
        @RequestBody @Valid ClienteConHistoriaRequest request) {
        
        Cliente clienteGuardado = clienteUseCase.registrarClienteConHistoriaClinica(
            request.getCliente(), 
            request.getDiagnostico()
           
        );
        
        return ResponseEntity.created(URI.create("/api/clientes/" + clienteGuardado.getId()))
                           .body(clienteGuardado);
    }

}