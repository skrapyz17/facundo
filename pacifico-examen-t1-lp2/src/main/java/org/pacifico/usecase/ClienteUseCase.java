package org.pacifico.usecase;

import java.time.LocalDate;
import java.util.List;
import org.pacifico.entity.bean.Cliente;

public interface ClienteUseCase {
	public List<Object[]> obtenerDiagnosticosClientesDesdeFecha(LocalDate fecha);
    public List<Cliente> obtenerClientesConApellidoA();
    public Cliente registrarClienteConHistoriaClinica(Cliente cliente, String diagnostico);
}
