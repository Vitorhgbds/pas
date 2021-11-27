package com.bcopstein.adaptadores;
/* TO DO
    IMPORTS
*/

@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
public class Controller {

    @Resource
    private ServicoVendas serviceVendas;
    private ServicoDeEstoque service;

    /*
        Na rota de venda registrar codigo do produto, Quantidade, preco do produto,
        Precisa diminuir esse valor do banco de dados local.
    */

    @GetMapping("/venda/produto") 
    @CrossOrigin(origins = "*")
    public void venda(@RequestParam int codigo, @RequestParam int qtd){
        if(serviceVendas.venda(codigo, qtd))
    }
    
    /*
    public ResponseEntity<> estatisticas(@RequestParam final int distancia){
        return new ResponseEntity<>(service.findById((long) distancia), OK);
    }
    */

    /*
        Produtos vendidos: deve retornar à relação de produtos disponíveis 
        para venda. Comunicação síncrona
    */
    @GetMapping("/venda") 
    @CrossOrigin(origins = "*")

    /*
        Chegada de itens no estoque: usada para informar a chegada de novos 
        itens no estoque. Comunicação síncrona.
    */

    @GetMapping("/estoque/adicionar") 
    @CrossOrigin(origins = "*")

    /*
        Baixa no estoque: deve atualizar a quantidade de um produto 
        no estoque subtraindo a quantidade vendida. Deve sinalizar caso 
        a operação não seja possível. Comunicação síncrona.
        codigo do produto + quantidade
    */

    @GetMapping("/estoque/remover") 
    @CrossOrigin(origins = "*")

    /*
        Desfazer baixa no estoque: deve somar novamente a quantidade vendida.
        Deve ser usada para operações de “rollback”
    */

    @GetMapping("/estoque/rollback") 
    @CrossOrigin(origins = "*")
}
