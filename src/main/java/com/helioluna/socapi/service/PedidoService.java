package com.helioluna.socapi.service;

import com.helioluna.socapi.domain.Pedido;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PedidoService {
    Pedido save(Pedido pedido);

    Optional<Pedido> consultarPorId(Long id);
}
