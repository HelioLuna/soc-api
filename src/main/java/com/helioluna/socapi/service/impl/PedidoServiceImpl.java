package com.helioluna.socapi.service.impl;

import com.helioluna.socapi.domain.Item;
import com.helioluna.socapi.domain.Pedido;
import com.helioluna.socapi.repository.ItemRepository;
import com.helioluna.socapi.repository.PedidoRepository;
import com.helioluna.socapi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Pedido save(Pedido pedido) {
        verificarExcessoesPedido(pedido);
        Item itemCriado = itemRepository.save(pedido.getItem());
        pedido.setItem(itemCriado);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> consultarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    private void verificarExcessoesPedido(Pedido pedido) {
        lancarExcecaoCasoQuantidadeNaoMutiplaOuZero(pedido);
        lancarExcecaoCasoPrecoUnitarioMenorIgualZero(pedido);
        lancarExcecaoCasoRentabilidadeRuim(pedido);
    }

    private void lancarExcecaoCasoQuantidadeNaoMutiplaOuZero(Pedido pedido) {
        if(pedido.getItem().getQuantidade() <= 0){
            throw new IllegalArgumentException("A quantidade precisa ser maior que zero.");
        } else if(pedido.getItem().getProduto().getMultiplo() != null &&
                pedido.getItem().getQuantidade() % pedido.getItem().getProduto().getMultiplo() != 0){
            throw new IllegalArgumentException("Este produto só pode ser vendido por mútiplos de "+ pedido.getItem().getProduto().getMultiplo());
        }
    }

    private void lancarExcecaoCasoPrecoUnitarioMenorIgualZero(Pedido pedido) {
        if(pedido.getItem().getPrecoUnitario() <= 0){
            throw new IllegalArgumentException("O preço unitário do produto precisa ser maior que zero.");
        }
    }

    private void lancarExcecaoCasoRentabilidadeRuim(Pedido pedido) {
        if(pedido.getItem().getPrecoUnitario() < retornaValorProdutoMenosDezPorCento(pedido)){
            throw new IllegalArgumentException("A rentabilidade do produto não pode está ruim, aumente o preço unitário até a rentabilidade está boa ou ótima.");
        }
    }

    private Double retornaValorProdutoMenosDezPorCento(Pedido pedido) {
        return pedido.getItem().getProduto().getPrecoUnitario() - (pedido.getItem().getPrecoUnitario() * 10 /100);
    }

}
