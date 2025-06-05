package org.pacifico.usecase;

import org.pacifico.entity.bean.HistoriaClinica;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface HistoriaClinicaUseCase {
    List<HistoriaClinica> buscarPorDniCliente(String dni);
}
