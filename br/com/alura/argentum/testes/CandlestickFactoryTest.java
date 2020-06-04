package br.com.alura.argentum.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.alura.argentum.modelo.Candlestick;
import br.com.alura.argentum.modelo.CandlestickFactory;
import br.com.alura.argentum.modelo.Negociacao;

public class CandlestickFactoryTest {

    @Test
    public void sequenciaSimplesDeNegociacoes() {
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(37.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(45.5, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(negociacoes, hoje);

        assertEquals(candle.abertura(), 40.5);
        assertEquals(candle.fechamento(), 42.5);
        assertEquals(candle.minimo(), 37.0);
        assertEquals(candle.maximo(), 45.5);
        assertEquals(candle.volume(), 16550.0);
    }

    @Test
    public void geraCandlestickComApenasUmaNegociacao() {
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao = new Negociacao(40.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao);

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(negociacoes, hoje);

        assertEquals(candle.abertura(), 40.5);
        assertEquals(candle.fechamento(), 40.5);
        assertEquals(candle.minimo(), 40.5);
        assertEquals(candle.maximo(), 40.5);
        assertEquals(candle.volume(), 4050.0);
    }

    @Test
    public void geraCandlestickComZeroEmCasoDeNenhumaNegociacao() {
        LocalDateTime hoje = LocalDateTime.now();

        List<Negociacao> negociacoes = new ArrayList<>();

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(negociacoes, hoje);

        assertEquals(candle.abertura(), 0);
        assertEquals(candle.fechamento(), 0);
        assertEquals(candle.minimo(), 0);
        assertEquals(candle.maximo(), 0);
        assertEquals(candle.volume(), 0);
    }
}