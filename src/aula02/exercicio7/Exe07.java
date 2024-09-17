package aula02.exercicio7;

import java.util.Scanner;

public class Exe07 {
    public static void main(String[] args) {
        double primeiroNumero,segundoNumero;
        Scanner ler = new Scanner(System.in);
        String opcao;

        System.out.println("-----Bem-Vindo a Calculadora!-----");
        System.out.println("Escolha uma opção de cálculo.");

        while (true) {
            System.out.println("Digite o Primeiro Valor: ");
            primeiroNumero = ler.nextDouble();
            System.out.println("Digite o Segundo Valor: ");
            segundoNumero = ler.nextDouble();
            System.out.println("A - Soma \n" + "B - Subtração \n" + "C - Divisão \n" + "D - Multiplicação \n" + "E - Exponenciação \n" + "F - Raíz Quadrada\n" + "N - Fechar Calculadora \n");
            opcao = ler.next().toUpperCase();
            System.out.println(opcao);

            switch (opcao) {
                case "A":
                    System.out.println("O resultado é: " + (primeiroNumero + segundoNumero));
                    break;
                case "B":
                    System.out.println("O resultado é: " + (primeiroNumero - segundoNumero));
                    break;
                case "C":
                    System.out.println("O resultado é: " + (primeiroNumero / segundoNumero));
                    break;
                case "D":
                    System.out.println("O resultado é: " + (primeiroNumero * segundoNumero));
                    break;
                case "E":
                    System.out.println("O resultado é: " + (Math.pow(primeiroNumero,segundoNumero)));
                    break;
                case "F":
                    System.out.println("O resultado é: " + (Math.sqrt(primeiroNumero)));
                    break;
                case "N":
                    System.out.println("Desligando Calculadora...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
