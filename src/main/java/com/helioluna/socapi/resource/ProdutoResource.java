package com.helioluna.socapi.resource;

import com.helioluna.socapi.domain.Produto;
import com.helioluna.socapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarClientes() {
        List<Produto> produtos = produtoService.findAll();
        return produtos != null ? ResponseEntity.ok(produtos) : ResponseEntity.notFound().build();
    }

}
