package com.helioluna.socapi.service.impl;

import com.helioluna.socapi.domain.Cliente;
import com.helioluna.socapi.repository.ClienteRepository;
import com.helioluna.socapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }


}
