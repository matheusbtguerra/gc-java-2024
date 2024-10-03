package aula07.exercicio21;

import java.util.Scanner;

public class Exe21 {
    public static void main(String[] args) {
        aceitaInteiro();
    }

    public static void aceitaInteiro(){
        Scanner ler = new Scanner(System.in);
        try {
            int numeroDigitado;
            System.out.println("Digite um número inteiro: ");
            numeroDigitado = ler.nextInt();
            if (numeroDigitado < 0){
                throw new IllegalArgumentException("O número " + numeroDigitado + " não é inteiro!");
            } else {
                System.out.println("O número " + numeroDigitado + " é inteiro.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
