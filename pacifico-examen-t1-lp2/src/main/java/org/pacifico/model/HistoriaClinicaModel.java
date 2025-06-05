package org.pacifico.model;

import org.pacifico.entity.bean.HistoriaClinica;
import org.pacifico.persistence.HistoriaClinicaRepository;
import org.pacifico.usecase.HistoriaClinicaUseCase;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoriaClinicaModel implements HistoriaClinicaUseCase {

    private final HistoriaClinicaRepository historiaClinicaRepository;


    public HistoriaClinicaModel(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public List<HistoriaClinica> buscarPorDniCliente(String dni) {
        return historiaClinicaRepository.findByClienteDni(dni);
    }
}