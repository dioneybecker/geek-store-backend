package com.pim.geekstore.services;

import com.pim.geekstore.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
