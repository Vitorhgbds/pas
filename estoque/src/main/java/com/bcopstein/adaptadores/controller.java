package com.bcopstein.adaptadores;

import java.util.List;

import com.bcopstein.aplicacao.UC_AdicionaEstoque;
import com.bcopstein.aplicacao.UC_ConsultaDisponibilidade;
import com.bcopstein.aplicacao.UC_ConsultaEstoque;
import com.bcopstein.aplicacao.UC_ConsultaProdutos;
import com.bcopstein.aplicacao.UC_RetiraEstoque;
import com.bcopstein.negocio.entidades.ItemEstoque;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/estoque")
public class controller {
  private UC_ConsultaProdutos consultaProdutos;
  private UC_ConsultaEstoque listaEstoque;
  private UC_ConsultaDisponibilidade consultaEstoque;
  private UC_RetiraEstoque retiraEstoque;
  private UC_AdicionaEstoque adicionaEstoque;

  @Autowired
  public controller(UC_ConsultaProdutos consultaProdutos, UC_ConsultaDisponibilidade consultaEstoque, UC_RetiraEstoque retiraEstoque, UC_AdicionaEstoque adicionaEstoque, UC_ConsultaEstoque listaEstoque) {
    this.consultaProdutos = consultaProdutos;
    this.consultaEstoque = consultaEstoque;
    this.retiraEstoque = retiraEstoque;
    this.adicionaEstoque = adicionaEstoque;
    this.listaEstoque = listaEstoque;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return this.consultaProdutos.run();
  }

  @PostMapping("/adiciona")
  @CrossOrigin(origins = "*")
  public boolean adicionaItemEstoque(@RequestBody ItemEstoque[] itens) {
    return this.adicionaEstoque.run(itens);
  }

  @PostMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestBody ItemVenda[] saleItems) {
    System.out.println("CHAMOU ESTOQUE");
    boolean retorno = true; 
    for (ItemVenda itemVenda : saleItems) {
      retorno = retorno && this.consultaEstoque.run(itemVenda.getCodigoProduto(), itemVenda.getQtd());
    }
    return retorno;
  }

  @GetMapping("/estoque")
  @CrossOrigin(origins = "*")
  public List<ItemEstoque> listaEstoque() {
    return this.listaEstoque.run();
  }

  @PostMapping("/retira")
  @CrossOrigin(origins = "*")
  public boolean retiraEstoque(@RequestBody ItemVenda[] itens) {
    return this.retiraEstoque.run(itens);
  }




  // @GetMapping("/autorizacao")
  // @CrossOrigin(origins = "*")

  // @PostMapping("/confirmacao")
  // @CrossOrigin(origins = "*")

  // @GetMapping("/historico")
  // @CrossOrigin(origins = "*")

  // @PostMapping("/subtotal")
  // @CrossOrigin(origins = "*")


}
