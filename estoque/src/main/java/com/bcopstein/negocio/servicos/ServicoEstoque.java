package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEstoque {
    private IEstoqueRepository estoqueRep;

    @Autowired
    // a que está no negocio IVendasRepository
    public ServicoEstoque(IEstoqueRepository estoqueRep){
        this.estoqueRep = estoqueRep;
    } 

    public List<ItemEstoque> listAll(){
        return estoqueRep.listAll();
    }

    public boolean add(ItemEstoque item){
        //Checa se já tem esse item
        for (ItemEstoque itemEstoque : this.listAll()) {
            if(item.getCodigoProduto() == itemEstoque.getCodigoProduto()){
                if(itemEstoque.getQtd() <0){
                    ItemEstoque novoItem = new ItemEstoque(item.getCodigoProduto(), item.getQtd());
                    return estoqueRep.add(novoItem);
                }else{
                    ItemEstoque novoItem = new ItemEstoque(item.getCodigoProduto(), item.getQtd() + itemEstoque.getQtd());
                    return estoqueRep.add(novoItem);
                }    
               
            }
        }
        return estoqueRep.add(item);
    }

    public boolean baixaEstoque(ItemVenda[] itens){
        System.out.println("Estoque ANTES da venda: ");
        this.listAll().stream().forEach(item -> System.out.println(item));
        //verifica se produto está disponível
        for (ItemVenda itemVenda : itens) {
            if(!consultaDisponibilidade(itemVenda.getCodigoProduto(), itemVenda.getQtd())){
                return false;
            }
        }
        //Se está tudo disponível, dá a baixa, abaixando a qtd no estoque daquele produto

        //MODO ANTIGO
        // for (ItemVenda itemVenda : itens) {
        //     this.listAll().stream().filter(item -> item.getCodigoProduto() == itemVenda.getCodigoProduto()).forEach(itemEstoque -> itemEstoque.removeQtd(itemVenda.getQtd()));
        // }

        //MODO COM ROLLBACK
        Long[] listaIds = new Long[itens.length];
        int[]  listaQtds = new int[itens.length];
        for(int i=0; i<itens.length; i++){
            listaIds[i] = -1L;
            listaQtds[i] = -1;
        }
        int index = 0;
        for (ItemVenda itemVenda : itens) {
            //Pega o estoque novamente para cada item
            List<ItemEstoque> lista = this.listAll();
            for (ItemEstoque itemEstoque : lista) {
                if(itemEstoque.getCodigoProduto() == itemVenda.getCodigoProduto()){
                    if(itemEstoque.getQtd() <= 0){
                        this.rollback(listaIds, listaQtds);
                        return false;
                    }else{
                        itemEstoque.removeQtd(itemVenda.getQtd());
                        listaIds[index] = itemEstoque.getCodigoProduto();
                        listaQtds[index] = itemVenda.getQtd();
                        index++;
                    }
                }
            }
        }

        System.out.println("Estoque depois da venda: ");
        this.listAll().stream().forEach(item -> System.out.println(item));
        this.listAll().stream().forEach(item -> this.persisteBD(item));
        return true;  
    }

    private boolean persisteBD(ItemEstoque item){
        return estoqueRep.add(item);
    }

    private void rollback(Long[] listaIds, int[] listaQtds){
        List<ItemEstoque> lista = this.listAll();
        for(int i=0; i<listaIds.length; i++){
            if(listaIds[i] == -1L){
                return;
            }
            for (ItemEstoque itemEstoque : lista) {
                if(itemEstoque.getCodigoProduto() == listaIds[i]){
                    this.add(new ItemEstoque(itemEstoque.getCodigoProduto(), listaQtds[i]));
                    break;
                }
            }
        }
    }

    public boolean consultaDisponibilidade(Long codProd, int qtd){
        return this.listAll().stream().anyMatch(item -> item.getCodigoProduto() == codProd && item.getQtd() >= qtd);
    }

    // public Produto get(Long codigo){
    //     return produtosRep.get(codigo);
    // }
}