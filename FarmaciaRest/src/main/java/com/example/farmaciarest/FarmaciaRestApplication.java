package com.example.farmaciarest;

import com.example.farmaciarest.entity.ItemPedido;
import com.example.farmaciarest.entity.Medicamento;
import com.example.farmaciarest.entity.Pedido;
import com.example.farmaciarest.repository.ItemPedidoRepository;
import com.example.farmaciarest.repository.MedicamentoRepository;
import com.example.farmaciarest.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FarmaciaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaRestApplication.class, args);
	}

}
