package com.example.farmaciarest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fabricante;
    private String nome;
    private double preco;

    @JsonIgnore
    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ItemPedido> itensPedido = new ArrayList<>();
}