package com.bcopstein.adaptadores.repositorios.crud;

import org.springframework.data.repository.CrudRepository;
import com.bcopstein.negocio.entidades.ItemEstoque;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstoqueCRUD extends CrudRepository<ItemEstoque, Long> {}
