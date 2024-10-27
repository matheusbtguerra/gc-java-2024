package aula06.exercicio19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exe19 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Map<String, Double> notaEstudantes = new HashMap<>();
        notaEstudantes.put("MATHEUS", 10.0);
        notaEstudantes.put("DONATELO", 8.5);
        notaEstudantes.put("MICHELANGELO", 9.0);
        notaEstudantes.put("RAFAEL", 7.8);
        notaEstudantes.put("LEONARDO", 9.7);

        boolean sair = true;
        while (sair) {
            System.out.println("\n----Inserção de Alunos---");
            System.out.println("1 - Adicionar Aluno\n2 - Sair");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do aluno a ser inserido: ");
                    String nomeDigitadoParaAdicionar = ler.nextLine().toUpperCase();
                    System.out.println("Digite a nota desse aluno: ");
                    Double notaParaAdicionar = ler.nextDouble();
                    notaEstudantes.put(nomeDigitadoParaAdicionar, notaParaAdicionar);
                    break;
                case 2:
                    sair = false;
                    break;
                default:
                    System.out.println("Opção digitada inválida!");
            }
        }

        while (!sair){
            System.out.println("\n---Verificar alunos na lista---");
            System.out.println("1 - Verificar nome na lista\n2 - Sair");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome de um(a) aluno(a) e verificarei se ele se encontra em nossa lista de estudantes");
                    String nomeDigitadoPesquisa = ler.nextLine().toUpperCase();
                    if (notaEstudantes.containsKey(nomeDigitadoPesquisa)) {
                        System.out.println("O aluno " + nomeDigitadoPesquisa + " foi encontrado em nossa lista de alunos! Sua nota é: " + notaEstudantes.get(nomeDigitadoPesquisa) + ".");
                    } else {
                        System.out.println("O aluno " + nomeDigitadoPesquisa + " não está presente em nossa lista de alunos...");
                    }
                    break;
                case 2:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção digitada inválida!");
            }
        }

        ler.close();
    }
}