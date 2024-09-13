package com.example.farmaciarest.controller;

import com.example.farmaciarest.entity.Pedido;
import com.example.farmaciarest.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    List<Pedido> all() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/pedidos/{id}")
    Optional<Pedido> getById(@PathVariable Integer id) {
        return pedidoRepository.findById(id);
    }

    @PostMapping("/pedidos")
    Pedido createNew(@Valid @RequestBody Pedido novoPedido) {
        novoPedido.setId(null);  // Garante que o ID será gerado automaticamente
        return pedidoRepository.save(novoPedido);
    }

    @DeleteMapping("/pedidos/{id}")
    void delete(@PathVariable Integer id) {
        pedidoRepository.deleteById(id);
    }

    @PutMapping("/pedidos/{id}")
    Pedido updateOrCreate(@RequestBody Pedido novoPedido, @PathVariable Integer id) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setClienteNome(novoPedido.getClienteNome());
                    pedido.setClienteCpf(novoPedido.getClienteCpf());
                    pedido.setItensPedido(novoPedido.getItensPedido());
                    return pedidoRepository.save(pedido);
                })
                .orElseGet(() -> {
                    novoPedido.setId(id);
                    return pedidoRepository.save(novoPedido);
                });
    }
}