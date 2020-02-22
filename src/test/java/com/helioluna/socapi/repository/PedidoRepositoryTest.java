package com.helioluna.socapi.repository;

import com.helioluna.socapi.domain.Cliente;
import com.helioluna.socapi.domain.Item;
import com.helioluna.socapi.domain.Pedido;
import com.helioluna.socapi.domain.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoRepositoryTest {

    @Autowired
    PedidoRepository pedidoRepository;

    @Test
    public void salvarTest(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Produto produto = new Produto();
        produto.setId(1L);
        produto.setMultiplo(0);
        produto.setPrecoUnitario(1500.0);

        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(1);
        item.setPrecoUnitario(1600.0);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setItem(item);

        Pedido createdPedido = pedidoRepository.save(pedido);
        assertThat(createdPedido.getId()).isNotNull();
    }


    @Test
    public void alterarTest(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);

        Produto produto = new Produto();
        produto.setId(1L);
        produto.setMultiplo(0);
        produto.setPrecoUnitario(1500.0);

        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(1);
        item.setPrecoUnitario(2000.0);

        Pedido pedido = new Pedido();
        pedido.setId(3L);
        pedido.setCliente(cliente);
        pedido.setItem(item);

        Pedido createdPedido = pedidoRepository.save(pedido);
        assertThat(createdPedido.getItem().getPrecoUnitario()).isEqualTo(2000.0);
    }

    @Test
    public void consultarPorId(){
        Optional<Pedido> result = pedidoRepository.findById(3L);
        assertThat(result.isPresent()).isFalse();
    }
}
