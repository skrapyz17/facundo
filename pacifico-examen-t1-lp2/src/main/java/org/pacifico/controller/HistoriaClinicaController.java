package org.pacifico.controller;

import org.pacifico.entity.bean.HistoriaClinica;
import org.pacifico.usecase.HistoriaClinicaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaUseCase historiaClinicaUseCase;


    public HistoriaClinicaController(HistoriaClinicaUseCase historiaClinicaUseCase) {
        this.historiaClinicaUseCase = historiaClinicaUseCase;
    }

    @GetMapping("/cliente/{dni}")
    public List<HistoriaClinica> getHistoriasPorDniCliente(@PathVariable String dni) {
        return historiaClinicaUseCase.buscarPorDniCliente(dni);
    }
}