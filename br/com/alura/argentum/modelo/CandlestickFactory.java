package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class CandlestickFactory {

    public Candlestick constroiCandleParaData(List<Negociacao> negociacoes, LocalDateTime date) {
        double abertura = negociacoes.get(0).preco();
        double fechamento = negociacoes.get(negociacoes.size() - 1).preco();

        double volume = 0;

        LocalDateTime data = LocalDateTime.now();

        double minimo = negociacoes.get(0).preco();
        double maximo = negociacoes.get(0).preco();

        for(Negociacao negociacao : negociacoes) {
            volume += negociacao.volume();

            if(negociacao.preco() > maximo) {
                maximo = negociacao.preco();
            } else if(negociacao.preco() < minimo) {
                minimo = negociacao.preco();
            }
        }

        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }
    
}