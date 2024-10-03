package aula07.exercicio23;

import java.util.Scanner;

public class Exe23 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int dividendo, divisor;
        try {
            System.out.println("Digite o dividendo: ");
            dividendo = ler.nextInt();
            System.out.println("Digite o divisor: ");
            divisor = ler.nextInt();
            System.out.println("O resultado da divisão é:"+ dividir(dividendo, divisor));
        } catch (ArithmeticException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Double dividir (int primeiro, int segundo) {
        if (segundo == 0){
            throw new ArithmeticException("Impossível realizar a divisão por zero!");
        } else {
            double resultado = primeiro / segundo;
            return resultado;
        }
    }
}
