package com.example.farmaciarest.controller;

import com.example.farmaciarest.entity.ItemPedido;
import com.example.farmaciarest.repository.ItemPedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacia")
public class ItemPedidoController {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @GetMapping("/itens-pedido")
    List<ItemPedido> all() {
        return itemPedidoRepository.findAll();
    }

    @GetMapping("/itens-pedido/{id}")
    Optional<ItemPedido> getById(@PathVariable Long id) {
        return itemPedidoRepository.findById(id);
    }

    @PostMapping("/itens-pedido")
    ItemPedido createNew(@Valid @RequestBody ItemPedido novoItemPedido) {
        novoItemPedido.setId(null);  // Garante que o ID será gerado automaticamente
        return itemPedidoRepository.save(novoItemPedido);
    }

    @DeleteMapping("/itens-pedido/{id}")
    void delete(@PathVariable Long id) {
        itemPedidoRepository.deleteById(id);
    }

    @PutMapping("/itens-pedido/{id}")
    ItemPedido updateOrCreate(@RequestBody ItemPedido novoItemPedido, @PathVariable Integer id) {
        return itemPedidoRepository.findById(Long.valueOf(id))
                .map(item -> {
                    item.setMedicamento(novoItemPedido.getMedicamento());
                    item.setQuantidade(novoItemPedido.getQuantidade());
                    return itemPedidoRepository.save(item);
                })
                .orElseGet(() -> {
                    novoItemPedido.setId(id);
                    return itemPedidoRepository.save(novoItemPedido);
                });
    }
}