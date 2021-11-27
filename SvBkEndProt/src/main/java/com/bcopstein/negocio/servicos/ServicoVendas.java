package com.bcopstein.negocio.servicos;

public class ServicoVendas {

    private final EstoqueRepository estoqueRepository;
    private final ServicoDe

    /*
        Fazer metodos para ser usados
        
        - Armazenar uma venda no banco de dados
        - Calcular, a partir do preco do produto e da quantidade, o subtotal, os impostos e o total a pagar
        - Diminuir o produto do banco de dados do estoque
  
        - •	Implementar um mecanismo de “rollback” para as vendas. Se no 
        momento de efetivar uma venda alguma das operações de “baixa no 
        estoque” falhar, toda a venda deve ser cancelada e mensagens para
        “repor” o que já foi retirado do estoque devem ser enviadas 
        (20% da nota)
    */

    /*  Lista de vendas: responde com a relação total das vendas efetuadas
        até agora. Deve ser usada comunicação síncrona através de um 
        “controller”.
    */
    public 


    // armazena venda no banco de dados, se for um sucesso ok, se não rollback
    public boolean venda(int codigo, int qtdade){

    }

    // para verificar se possui produto no estoque
    public boolean verifyEstoque(int codigo, int qtdade){
        
    }

    public void rollback(){

    }




}
