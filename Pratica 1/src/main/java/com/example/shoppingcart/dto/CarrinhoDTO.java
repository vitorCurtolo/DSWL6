package com.example.shoppingcart.dto;

import com.example.shoppingcart.model.Carrinho;
import com.example.shoppingcart.model.Cliente;
import com.example.shoppingcart.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO implements IDTO<Carrinho> {

    // Lista que armazena todos os carrinhos
    private static List<Carrinho> carrinhos = new ArrayList<>();

    @Override
    public void save(Carrinho carrinho) {
        carrinhos.add(carrinho);
    }

    @Override
    public void update(Carrinho carrinho) {
        for (int i = 0; i < carrinhos.size(); i++) {
            if (carrinhos.get(i).getId().equals(carrinho.getId())) {
                carrinhos.set(i, carrinho);
                break;
            }
        }
    }

    @Override
    public List<Carrinho> list() {
        return carrinhos;
    }

    // Método para listar os carrinhos de um cliente específico
    public List<Carrinho> listByCliente(Cliente cliente) {
        List<Carrinho> carrinhosDoCliente = new ArrayList<>();
        for (Carrinho carrinho : carrinhos) {
            if (carrinho.getCliente().getId().equals(cliente.getId())) {
                carrinhosDoCliente.add(carrinho);
            }
        }
        return carrinhosDoCliente;
    }

    // Método para listar todos os produtos de todos os carrinhos de um cliente específico
    public List<Produto> listProdutosByCliente(Cliente cliente) {
        List<Produto> produtosDoCliente = new ArrayList<>();
        for (Carrinho carrinho : carrinhos) {
            if (carrinho.getCliente().getId().equals(cliente.getId())) {
                produtosDoCliente.addAll(carrinho.getProdutos());
            }
        }
        return produtosDoCliente;
    }
}
