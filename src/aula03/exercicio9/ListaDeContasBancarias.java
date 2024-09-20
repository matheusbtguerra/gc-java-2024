package aula03.exercicio9;

import java.util.ArrayList;
import java.util.List;

public class ListaDeContasBancarias {
    private static ListaDeContasBancarias instancia;
    protected List<ContaBancaria> contas = new ArrayList<>();

    public static ListaDeContasBancarias getInstancia() {
        if (instancia == null) {
            instancia = new ListaDeContasBancarias();
        }
        return instancia;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void removerConta(int id) {
        contas.removeIf(contaBancaria -> contaBancaria.getIdentificadorConta() == id);
    }

    public void listarContas() {
        for (ContaBancaria conta : contas) {
            conta.mostrarInformacoes();
        }
    }
}
