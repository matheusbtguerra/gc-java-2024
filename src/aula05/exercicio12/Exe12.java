package aula05.exercicio12;

import java.util.Scanner;

public class Exe12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números deseja inserir? ");
        int tamanho = sc.nextInt();

        int somaArray[] = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite o valor 0" + (i + 1) + ": ");
            somaArray[i] = sc.nextInt();
        }

        int soma = 0;
        for (int numeros : somaArray) {
            soma += numeros;
        }
        double media = (double) soma / tamanho;

        System.out.print("A soma dos números é de: " + soma);
        System.out.printf("\nA média dos números é de: %.2f", media);

        sc.close();
    }
}