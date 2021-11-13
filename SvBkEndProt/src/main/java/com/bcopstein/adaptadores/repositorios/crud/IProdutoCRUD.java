package com.bcopstein.adaptadores.repositorios.crud;

import com.bcopstein.negocio.entidades.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoCRUD extends CrudRepository<Produto, Long> {
    List<Produto> todos();
}
