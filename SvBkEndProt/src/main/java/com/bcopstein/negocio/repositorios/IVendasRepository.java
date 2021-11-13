package com.bcopstein.negocio.repositorios;

import com.bcopstein.negocio.entidades.Venda;

public interface IVendasRepository {

    void salvar(Venda venda);
    Venda recuperar(int numero);

}