package com.example.farmaciarest.controller;

import com.example.farmaciarest.entity.Medicamento;
import com.example.farmaciarest.repository.MedicamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class MedicamentoController {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @GetMapping("/medicamentos")
    List<Medicamento> all() {
        return medicamentoRepository.findAll();
    }

    @GetMapping("/medicamentos/{id}")
    Optional<Medicamento> getById(@PathVariable String id) {
        return medicamentoRepository.findById(id);
    }

    @PostMapping("/medicamentos")
    Medicamento createNew(@Valid @RequestBody Medicamento novoMedicamento) {
        novoMedicamento.setId(null);  // Garante que o código será gerado automaticamente
        return medicamentoRepository.save(novoMedicamento);
    }

    @DeleteMapping("/medicamentos/{id}")
    void delete(@PathVariable String codigo) {
        medicamentoRepository.deleteById(codigo);
    }

    @PutMapping("/medicamentos/{id}")
    Medicamento updateOrCreate(@RequestBody Medicamento novoMedicamento, @PathVariable Integer id) {
        return medicamentoRepository.findById(String.valueOf(id))
                .map(medicamento -> {
                    medicamento.setFabricante(novoMedicamento.getFabricante());
                    medicamento.setNome(novoMedicamento.getNome());
                    medicamento.setPreco(novoMedicamento.getPreco());
                    return medicamentoRepository.save(medicamento);
                })
                .orElseGet(() -> {
                    novoMedicamento.setId(id);
                    return medicamentoRepository.save(novoMedicamento);
                });
    }
}