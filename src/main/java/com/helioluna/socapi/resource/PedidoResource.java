package com.helioluna.socapi.resource;

import com.helioluna.socapi.domain.Pedido;
import com.helioluna.socapi.service.PedidoService;
import com.helioluna.socapi.util.interfaces.Save;
import com.helioluna.socapi.util.interfaces.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/salvar")
    public ResponseEntity<Pedido> save(@RequestBody @Validated({Save.class}) Pedido pedido) {
        Pedido pedidoResult = pedidoService.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResult);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Pedido> alterar(@RequestBody @Validated({Update.class}) Pedido pedido) {
        Pedido pedidoResult = pedidoService.save(pedido);
        return ResponseEntity.ok(pedidoResult);
    }

    @GetMapping("/consultarPorId/{id}")
    public ResponseEntity<Optional<Pedido>> consultarPorId(@PathVariable("id") Long id){
        Optional<Pedido> pedidoResult = pedidoService.consultarPorId(id);
        return ResponseEntity.ok(pedidoResult);
    }
}
