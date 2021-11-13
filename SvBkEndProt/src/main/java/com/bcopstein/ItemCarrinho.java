package com.bcopstein;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ItemCarrinho {
    private int codigo;
    private int quantidade;

    @Override
    public String toString() {
        return "ItemCarrinho [codigo=" + codigo + ", qtd=" + quantidade + "]";
    }
}
