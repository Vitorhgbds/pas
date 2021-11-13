package com.bcopstein.adaptadores.repositorios.crud;

import com.bcopstein.negocio.entidades.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendasCRUD extends CrudRepository<Venda, Long> {
    List<Venda> salvar();
    List<Venda> recuperar();
}
