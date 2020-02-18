package com.helioluna.socapi.service.impl;

import com.helioluna.socapi.domain.Produto;
import com.helioluna.socapi.repository.ProdutoRepository;
import com.helioluna.socapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
