package com.bcopstein.aplicacao;

import java.time.LocalDateTime;

import com.bcopstein.adaptadores.client.EstoqueClient;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UC_RegistraVenda {
    private ServicoVendas servicoVendas;
    private final EstoqueClient estoqueClient;

    @Autowired
    public UC_RegistraVenda(ServicoVendas servicoVendas, EstoqueClient estoqueClient) {
        this.servicoVendas = servicoVendas;
        this.estoqueClient = estoqueClient;
    }
    
    public boolean run(ItemVenda[] itens){

        //Cria uma nova venda e cadastra
        LocalDateTime now = LocalDateTime.now();
        if(servicoVendas.temRestricao(itens))
            return false;

        //verifica no microservico de estoque se produto está disponível
        if(verificaDisponibilidadeProduto(itens)){
            System.out.println("MANDANDO PRO CLIENT DE ESTOQUE AGORA ");
            var resposta = estoqueClient.retiraEstoque(itens);
            if(!resposta){
                return false;
            }

            int subtotal = 0;
            for (ItemVenda itemVenda : itens) {
                subtotal += itemVenda.getPrecoUnitario() * itemVenda.getQtd();
            }

            Venda venda = new Venda(now, itens, servicoVendas.calculaImposto(itens), subtotal);
            return this.servicoVendas.add(venda);
        }else{
            return false;
        }
    }

    public boolean verificaDisponibilidadeProduto(ItemVenda[] itens){
        return this.estoqueClient.verificaDisponibilidadeProduto(itens);
    }
}

