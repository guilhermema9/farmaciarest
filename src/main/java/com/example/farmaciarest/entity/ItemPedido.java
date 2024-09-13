package com.example.farmaciarest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@JsonUnwrapped
    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    //@JsonUnwrapped
    @ManyToOne
    //@JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private int quantidade;
}