package com.helioluna.socapi.resource;

import com.helioluna.socapi.domain.Cliente;
import com.helioluna.socapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listarClientesPorNome/{nome}")
    public ResponseEntity<List<Cliente>> findAllByName(@PathVariable("nome") String nome) {
        List<Cliente> clientes = clienteService.findAllByName(nome);
        return ResponseEntity.ok(clientes);
    }
}
