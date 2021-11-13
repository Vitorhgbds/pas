package com.bcopstein.negocio.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Produto {

    private final int codigo;
    private final String descricao;
    private int qtdade;

    @Setter
    private double preco;

    public void saidaDeProduto(int qtdade) {
        this.qtdade -= qtdade;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco
                + ", qtdade=" + qtdade + "]";
    }
}
