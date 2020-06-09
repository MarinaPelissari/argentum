package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

public final class Negociacao {
    private final double preco;
    private final int quantidade;
    private final LocalDateTime data;

    public Negociacao(double preco, int quantidade, LocalDateTime data) {
        if(preco <= 0) {
            throw new IllegalArgumentException("O preço não pode ser zero ou negativo!");
        }
        if(quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade não pode ser zero ou negativa!");
        }
        if(data == null) {
            throw new IllegalArgumentException("A data não pode ser nula!");
        }

        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double preco() {
        return this.preco;
    }

    public int quantidade() {
        return this.quantidade;
    }

    public LocalDateTime data() {
        return this.data;
    }

    public double volume() {
        return preco * quantidade;
    }
}