package com.bcopstein.aplicacao;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.servicos.ServicoEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UC_ConsultaEstoque {
    private ServicoEstoque servicoEstoque;

    @Autowired
    public UC_ConsultaEstoque(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }
    
    public List<ItemEstoque> run(){
        return this.servicoEstoque.listAll();
    }
}
