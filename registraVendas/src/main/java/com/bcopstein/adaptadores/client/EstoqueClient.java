package com.bcopstein.adaptadores.client;

import org.springframework.web.reactive.function.client.WebClient;

import com.bcopstein.negocio.entidades.ItemVenda;

import org.springframework.stereotype.Component;

@Component
public class EstoqueClient {

    private final WebClient webClient;

    public EstoqueClient() {
        this.webClient = WebClient.create("http://servEstoque:8080/");
    }

    public Boolean verificaDisponibilidadeProduto(ItemVenda[] saleItems) {
        System.out.println("SÓ MANDA ESSES ITENS PELO AMOR");
        for (ItemVenda itemVenda : saleItems) {
            System.out.println(itemVenda);
        }
        return webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("estoque/autorizacao").build())
                .bodyValue(saleItems)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean retiraEstoque(ItemVenda[] saleItems) {
        return webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("estoque/retira").build())
                .bodyValue(saleItems)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
