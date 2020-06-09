package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

public class Candlestick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volume;
    private final LocalDateTime data;

    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume,
            LocalDateTime data) {

        if(minimo > maximo) {
            throw new IllegalArgumentException("O mínimo não pode ser maior o máximo!");
        }

        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public double abertura() {
        return abertura;
    }

    public double fechamento() {
        return fechamento;
    }

    public double minimo() {
        return minimo;
    }

    public double maximo() {
        return maximo;
    }

    public double volume() {
        return volume;
    }

    public LocalDateTime data() {
        return data;
    }

    public boolean isAlta() {
        return this.abertura < this.fechamento;
    }

    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }
}