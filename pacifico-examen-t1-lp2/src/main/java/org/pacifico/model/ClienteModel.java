package org.pacifico.model;

import org.pacifico.entity.bean.Cliente;
import org.pacifico.entity.bean.HistoriaClinica;
import org.pacifico.persistence.ClienteRepository;
import org.pacifico.usecase.ClienteUseCase;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteModel implements ClienteUseCase {

    private final ClienteRepository clienteRepository;


    public ClienteModel(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Object[]> obtenerDiagnosticosClientesDesdeFecha(LocalDate fecha) {
        return clienteRepository.findDiagnosticosClientes2024(fecha);
    }

    @Override
    public List<Cliente> obtenerClientesConApellidoA() {
        return clienteRepository.findByApellidoComienzanConA();
    }
    
    @Transactional
    public Cliente registrarClienteConHistoriaClinica(Cliente cliente, String diagnostico) {
        
        if (cliente == null || diagnostico == null || diagnostico.isBlank()) {
            throw new IllegalArgumentException("Datos del cliente o diagnóstico no pueden ser nulos/vacíos");
        }

        
        HistoriaClinica historia = new HistoriaClinica();
        historia.setDiagnostico(diagnostico);
        historia.setFecha(LocalDate.now());
        historia.setCliente(cliente);
        
        cliente.getHistoriasClinicas().add(historia);
    
        return clienteRepository.save(cliente);
    }

}
