package com.pim.geekstore.controllers;

import com.pim.geekstore.models.Pedido;
import com.pim.geekstore.repositories.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/pedido")
@CrossOrigin
public class PedidoController {
    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        return ResponseEntity.ok().body(this.pedidoRepository.save(pedido));
    }
}
