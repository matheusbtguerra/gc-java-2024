package aula07.exercicio21;

import java.util.Scanner;

public class Exe21 {
    public static void main(String[] args) {
        try {
            aceitaInteiro();
        } catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void aceitaInteiro(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um número inteiro positivo: ");
        int numeroDigitado = ler.nextInt();
        if (numeroDigitado < 0){
            throw new IllegalArgumentException("O número digitado é negativo!");
        } else {
            System.out.println("O número digitado é válido!");
        }

    }
}
