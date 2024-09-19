package aula03.exercicio9;

import java.util.ArrayList;
import java.util.List;

public class ListaDeContasBancarias {

    private List<ContaBancaria> listaContaBancaria = new ArrayList();

    public void setListaContaBancaria(ContaBancaria contaBancaria) {
        listaContaBancaria.add(contaBancaria);
    }

    public ContaBancaria getListaContaBancaria() {
        for (ContaBancaria conta : listaContaBancaria) {
            return conta;
        }
        return null;
    }

    public void removerContaBancaria(int id) {
        for (ContaBancaria conta : listaContaBancaria) {
            if (conta.getIdentificadorConta() == id) {
                listaContaBancaria.remove(conta);
            }
        }
    }

    public void removerContaBancaria(ContaBancaria contaBancaria) {
        listaContaBancaria.remove(contaBancaria);
    }
}
