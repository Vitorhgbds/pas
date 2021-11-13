package com.bcopstein.negocio.repositorios;


import com.bcopstein.negocio.entidades.Produto;

import java.util.List;

public interface IProdutoRepository {
    List<Produto> todos();
}
