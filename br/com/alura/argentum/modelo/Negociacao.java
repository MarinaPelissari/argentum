package br.com.alura.argentum.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Negociacao {
    private final BigDecimal preco;
    private final int quantidade;
    private final LocalDateTime data;

    public Negociacao(BigDecimal preco, int quantidade, LocalDateTime data) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public BigDecimal preco() {
        return this.preco;
    }

    public int quantidade() {
        return this.quantidade;
    }

    public LocalDateTime data() {
        return this.data;
    }
}