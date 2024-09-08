package com.example.farmaciarest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    //@JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    //@JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    private int quantidade;

}

