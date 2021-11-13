package com.bcopstein.adaptadores.repositorios;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendasRepository implements IVendasRepository {
    private IVendasRepository vendasCrud;

    @Override
    public void salvar(Venda venda) {
        vendasCrud.salvar(venda);
    }

    @Override
    public Venda recuperar(int numero) {
        vendasCrud.recuperar(numero);
        return null;
    }
}
