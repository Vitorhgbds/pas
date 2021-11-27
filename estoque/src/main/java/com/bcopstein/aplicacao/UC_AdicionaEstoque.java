package com.bcopstein.aplicacao;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoEstoque;
import com.bcopstein.negocio.servicos.ServicoProdutos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UC_AdicionaEstoque {
    private ServicoEstoque servicoEstoque;
    private ServicoProdutos servicoProdutos;

    @Autowired
    public UC_AdicionaEstoque(ServicoEstoque servicoEstoque, ServicoProdutos servicoProdutos) {
        this.servicoEstoque = servicoEstoque;
        this.servicoProdutos = servicoProdutos;
    }
    
    public boolean run(ItemEstoque[] itens){
        // Checa se o item estoque possui produto correspondente
        boolean corresponde = false;
        List<Produto> produtos = servicoProdutos.listAll();
        for (ItemEstoque item : itens) {
            corresponde = false;
            for (Produto produto : produtos) {
                if(produto.getCodigo() == item.getCodigoProduto()){
                    corresponde = true;
                    break;
                }
            }
            if(!corresponde){
                return false;
            }
        }

        // Adiciona no estoque
        boolean retorno = true;
        for (ItemEstoque itemEstoque : itens) {
            retorno = retorno && servicoEstoque.add(itemEstoque);
        }
        return retorno;
    }
    
}
