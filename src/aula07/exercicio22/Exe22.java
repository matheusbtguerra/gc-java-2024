package aula07.exercicio22;

import aula07.exercicio22.ValorInvalidoException;

import java.util.Scanner;

//desculpa pelo erro juvenil :(
public class Exe22 {
    public static void main(String[] args) {
        maiorQueDez();
    }

    public static void maiorQueDez(){
        Scanner ler = new Scanner(System.in);
        try {
            int numeroDigitado;
            System.out.println("Digite um número maior ou igual a dez: ");
            numeroDigitado = ler.nextInt();
            if (numeroDigitado < 10){
                throw new ValorInvalidoException("O número " + numeroDigitado + " é menor que 10!");
            } else {
                System.out.println("O número " + numeroDigitado + " é maior ou igual a 10.");
            }
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
