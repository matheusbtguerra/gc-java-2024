package aula03.exercicio9.repositorio;

import aula03.exercicio9.entidade.ContaBancaria;

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


    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void removerConta(int id) {
        contas.removeIf(contaBancaria -> contaBancaria.getIdentificadorConta() == id);
    }

    public ContaBancaria procurarConta(int id) {
        for (ContaBancaria conta : contas) {
            if (conta.getIdentificadorConta() == id) {
                return conta;
            }
        }
        return null;
    }

    public void mostrarInformacoesParciais() {
        for (ContaBancaria conta : contas) {
            conta.mostrarInformacoesParciais();
        }
    }
}
