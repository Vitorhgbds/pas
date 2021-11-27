package com.bcopstein.aplicacao;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_RetiraEstoque {
    private ServicoEstoque servicoEstoque;

    @Autowired
    public UC_RetiraEstoque(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }
    
    public boolean run(ItemVenda[] itens){
        return servicoEstoque.baixaEstoque(itens);
    }
}
