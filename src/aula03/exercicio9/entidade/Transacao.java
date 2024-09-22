package aula03.exercicio9.entidade;

import aula03.exercicio9.utilitario.DataUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transacao {

    private static int contadorTransacao = 1;
    private int id;
    private Descricao descricao;
    private ContaBancaria origem;
    private ContaBancaria destino;
    private double valor;
    private LocalDate dataTransacao;
    private LocalTime tempoTransacao;
    private String data;
    private String hora;

    public Transacao(Descricao descricao, ContaBancaria origem, double valor) {
        this.id = contadorTransacao++;
        this.descricao = descricao;
        this.origem = origem;
        this.valor = valor;
        this.destino = null;
        this.dataTransacao = LocalDate.now();
        this.tempoTransacao = LocalTime.now();
        this.data = DataUtils.formatData(dataTransacao);
        this.hora = DataUtils.formatHora(tempoTransacao);
    }

    public Transacao(Descricao descricao, ContaBancaria origem, ContaBancaria destino, double valor) {
        this.id = contadorTransacao++;
        this.descricao = descricao;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.dataTransacao = LocalDate.now();
        this.data = DataUtils.formatData(dataTransacao);
        this.hora = DataUtils.formatHora(tempoTransacao);
    }

    public int getId() {
        return id;
    }

    public ContaBancaria getOrigem() {
        return origem;
    }

    public ContaBancaria getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return String.format("""
                
                Transacao{
                    id=%d,
                    descricao=%s,
                    origem=%s,
                    destino=%s,
                    valor=%.2f,
                    momentoTransacao=%s,
                    data='%s',
                    hora='%s'
                }
                """, id, descricao, origem, destino, valor, dataTransacao, data, hora);
    }
}
