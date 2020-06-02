package br.com.alura.argentum.testes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.alura.argentum.modelo.Candlestick;
import br.com.alura.argentum.modelo.CandlestickFactory;
import br.com.alura.argentum.modelo.Negociacao;

public class TesteCandlestickFactory {
    
    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();

        Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
        Negociacao negociacao2 = new Negociacao(37.0, 100, hoje);
        Negociacao negociacao3 = new Negociacao(45.5, 100, hoje);
        Negociacao negociacao4 = new Negociacao(42.5, 100, hoje);

        List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(negociacoes, hoje);

        System.out.println("Abertura: " + candle.abertura());
        System.out.println("Fechamento: " + candle.fechamento());
        System.out.println("Mínimo: " + candle.minimo());
        System.out.println("Máximo: " + candle.maximo());
        System.out.println("Volume: " + candle.volume());
    }
}