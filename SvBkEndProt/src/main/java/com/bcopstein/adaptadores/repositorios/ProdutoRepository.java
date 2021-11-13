package com.bcopstein.adaptadores.repositorios;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProdutoRepository implements IProdutoRepository {
    private IProdutoRepository produtosCrud;

    @Override
    public List<Produto> todos() {
        List<Produto> resp = produtosCrud.todos();
        return resp;
    }
}
