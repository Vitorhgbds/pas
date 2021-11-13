package com.bcopstein.negocio.entidades;

import java.util.Date;

public class Venda {
    private long numero;
    private Date data;

    public int subtotal() { return 0; }
    public int impostos() { return 0; }
    public int totalPagar() { return 0; }
}
