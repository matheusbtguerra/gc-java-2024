package aula05.exercicio13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Exe13 {
    public static void main(String[] args) {
        //Feito em coop por Matheus Guerra, Rodrigo Weber e Rafael Mainieri.
        Scanner input = new Scanner(System.in);
        LocalDate data = LocalDate.of(2024, 9, 30);
        Compra compra1 = new Compra("Tomate", data);
        Compra compra2 = new Compra("Arroz", data);

        ArrayList<Compra> listaDeCompras = new ArrayList<>();
        int condicaoLoop = 0;

        while (condicaoLoop != 4) {
            System.out.println("[1] Exibir Lista de Compras");
            System.out.println("[2] Adicionar item");
            System.out.println("[3] Remover item");
            System.out.println("[4] Sair");
            System.out.print("Escolha: ");

            int escolha = input.nextInt();


            switch (escolha) {
                case 1:
                    System.out.println("=== Lista de Compras ===");
                    if (listaDeCompras.isEmpty()) {
                        System.out.println("A lista está vazia\n");
                        break;
                    } else {
                        exibirLista(listaDeCompras);
                        break;
                    }

                case 2:
                    System.out.print("Item: ");
                    String item = input.nextLine();
                    item = input.nextLine();

                    System.out.println("Data de validade");
                    System.out.print("Dia: ");
                    int dia = input.nextInt();

                    System.out.print("Mês: ");
                    int mes = input.nextInt();

                    System.out.print("Ano: ");
                    int ano = input.nextInt();

                    LocalDate dataValidade = LocalDate.of(ano, mes, dia);

                    Compra compra = new Compra(item, dataValidade);
                    listaDeCompras.add(compra);
                    System.out.println("Compra adicionada à lista com sucesso!\n");
                    break;

                case 3:
                    if (listaDeCompras.isEmpty()) {
                        System.out.println("A lista está vazia!");
                        break;
                    } else {
                        System.out.println("=== Lista de Compras ===");
                        exibirLista(listaDeCompras);
                        System.out.print("Escreva o item que deseja remover: ");
                        String itemRmv = input.nextLine();
                        itemRmv = input.nextLine();
                        for (int i = 0; i < listaDeCompras.size(); i++) {
                            if (listaDeCompras.get(i).getNome().equalsIgnoreCase(itemRmv)) {
                                listaDeCompras.remove(i);
                                System.out.println("Item removido com sucesso!");
                                break;
                            } else {
                                System.out.println("Esse item não existe");
                                break;
                            }
                        }
                    }

                case 4:
                    condicaoLoop = escolha;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

    }

    public static void exibirLista(ArrayList<Compra> lista) {
        for (int i = 0; i < lista.size(); i++) {
            int numItem = i + 1;
            System.out.println("Item " + numItem + ": " + lista.get(i).getNome());
            System.out.println("Validade: " + lista.get(i).getData());
            System.out.println("-----");
        }
        System.out.println("");
    }
}