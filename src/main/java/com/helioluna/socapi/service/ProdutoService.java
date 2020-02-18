package com.helioluna.socapi.service;

import com.helioluna.socapi.domain.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProdutoService {

    List<Produto> findAll();
}
