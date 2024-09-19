package aula03.exercicio9;

import aula03.exercicio9.utilitarios.DataUtils;

import java.util.Date;

public class Transacao {

    private static int contadorTransacao = 1;
    private int id;
    private Descricao descricao;
    private ContaBancaria origem;
    private ContaBancaria destino;
    private double valor;
    private Date momentoTransacao;
    private String data;
    private String hora;

    public Transacao(Descricao descricao, ContaBancaria origem, double valor) {
        this.id = contadorTransacao++;
        this.descricao = descricao;
        this.origem = origem;
        this.valor = valor;
        this.destino = null;
        this.momentoTransacao = new Date();
        this.data = DataUtils.formatData(momentoTransacao);
        this.hora = DataUtils.formatHora(momentoTransacao);
    }

    public Transacao(Descricao descricao, ContaBancaria origem, ContaBancaria destino, double valor) {
        this.id = contadorTransacao++;
        this.descricao = descricao;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.momentoTransacao = new Date();
        this.data = DataUtils.formatData(momentoTransacao);
        this.hora = DataUtils.formatHora(momentoTransacao);
    }

    public int getId() {
        return id;
    }

    public Descricao getDescricao() {
        return descricao;
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

    public Date getMomentoTransacao() {
        return momentoTransacao;
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
            """, id, descricao, origem, destino, valor, momentoTransacao, data, hora);
    }
}
