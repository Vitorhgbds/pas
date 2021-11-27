package com.bcopstein.adaptadores;

import java.util.List;

import com.bcopstein.aplicacao.UC_ConsultaHistoricoVendas;
import com.bcopstein.aplicacao.UC_RegistraVenda;
import com.bcopstein.negocio.entidades.ItemVenda;
import com.bcopstein.negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/vendas")
public class controller {
  private UC_ConsultaHistoricoVendas consultaHistoricoVendas;
  private UC_RegistraVenda registraVenda;

  @Autowired
  public controller(UC_ConsultaHistoricoVendas consultaHistoricoVendas, UC_RegistraVenda registraVenda) {
    this.consultaHistoricoVendas = consultaHistoricoVendas;
    this.registraVenda = registraVenda;
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> listaVendas() {
    System.out.println("histórico");
    return this.consultaHistoricoVendas.run();
  }



  @PostMapping("/registrar")
  @CrossOrigin(origins = "*")
  public boolean registraVenda(@RequestBody ItemVenda[] itens) {
    return this.registraVenda.run(itens);
  }

  @GetMapping("/registrarteste")
  @CrossOrigin(origins = "*")
  public boolean registraVendateste() {
    System.out.println("Teste");
    ItemVenda[] itens = new ItemVenda[2];
    itens[0] = new ItemVenda(2, 200.0, 1L);
    itens[1] = new ItemVenda(2, 100.0, 2L);
    for (ItemVenda itemVenda : itens) {
      System.out.println(itemVenda);
    }
    return this.registraVenda.run(itens);
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
