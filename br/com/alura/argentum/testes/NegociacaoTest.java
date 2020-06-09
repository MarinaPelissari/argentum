package br.com.alura.argentum.testes;

import java.time.LocalDateTime;

import org.junit.Test;

import br.com.alura.argentum.modelo.Negociacao;

public class NegociacaoTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoComDataNula() {
        new Negociacao(20, 10, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoSemPreco() {
        new Negociacao(0, 10, LocalDateTime.now());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoSemQuantidade() {
        new Negociacao(20, 0, LocalDateTime.now());
    }
}