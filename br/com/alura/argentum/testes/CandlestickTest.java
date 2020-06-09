package br.com.alura.argentum.testes;

import java.time.LocalDateTime;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.argentum.modelo.CandleBuilder;
import br.com.alura.argentum.modelo.Candlestick;

public class CandlestickTest {
    @Test
    public void test() {
        CandleBuilder builder = new CandleBuilder();

        Candlestick candle = builder.comAbertura(10.0).comFechamento(20.0).comMinimo(10.0).comMaximo(20.0)
                .comVolume(100.0).comData(LocalDateTime.now()).geraCandle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        CandleBuilder builder = new CandleBuilder();

        Candlestick candle = builder.comAbertura(10.0).comFechamento(20.0).comMinimo(30.0).comMaximo(20.0)
                .comVolume(100.0).comData(LocalDateTime.now()).geraCandle();
    }
}