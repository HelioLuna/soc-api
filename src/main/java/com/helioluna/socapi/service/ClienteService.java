package com.helioluna.socapi.service;

import com.helioluna.socapi.domain.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClienteService {

    List<Cliente> findAllByName(String nome);
}
