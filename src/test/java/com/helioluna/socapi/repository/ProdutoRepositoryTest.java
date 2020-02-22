package com.helioluna.socapi.repository;

import com.helioluna.socapi.domain.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    public void listarProdutosTest(){
        List<Produto> produtos = produtoRepository.findAll();
        assertThat(produtos.size()).isNotZero();
    }
}
