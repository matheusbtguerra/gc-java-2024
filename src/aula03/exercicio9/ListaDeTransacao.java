package aula03.exercicio9;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTransacao {
    private static ListaDeTransacao instancia;
    protected List<Transacao> transacoes = new ArrayList<>();

    public static ListaDeTransacao getInstancia() {
        if (instancia == null) {
            instancia = new ListaDeTransacao();
        }
        return instancia;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void removerTransacao(int id) {
        transacoes.removeIf(transacao -> transacao.getId() == id);
    }

    public void listarTransacoes() {
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }

}
