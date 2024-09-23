package aula03.exercicio9;


// Feito por Matheus Guerra e Henrique Alibio

import aula03.exercicio9.entidade.ContaBancaria;
import aula03.exercicio9.repositorio.ListaDeContasBancarias;
import aula03.exercicio9.utilitario.MenuBancario;

public class Exe09 {
    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria("Alibio", "000.000.000-54", "Santander", "Rua do Caldeira");
        ContaBancaria conta2 = new ContaBancaria("Matheus", "000.000.000-55", "Santander", "Rua do Caldeira");
        ContaBancaria conta3 = new ContaBancaria("Rafael", "000.000.000-56","Banrisul","Rua do Caldeira");

        MenuBancario menuBancario = new MenuBancario();

        menuBancario.menu();

    }
}
