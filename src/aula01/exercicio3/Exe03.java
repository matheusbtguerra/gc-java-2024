package aula01.exercicio3;
import java.util.Scanner;

public class Exe03 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double primeiroNumero, segundoNumero, terceiroNumero;

        System.out.println("---------Maior, Menor e Média de 3 Números---------");
        System.out.print("Digite o primeiro número: ");
        primeiroNumero = ler.nextDouble();
        System.out.print("Digite o segundo número: ");
        segundoNumero = ler.nextDouble();
        System.out.print("Digite o terceiro número: ");
        terceiroNumero = ler.nextDouble();

        double maior = Math.max(primeiroNumero, Math.max(segundoNumero, terceiroNumero));
        double menor = Math.min(primeiroNumero, Math.min(segundoNumero, terceiroNumero));
        double media = (primeiroNumero + segundoNumero + terceiroNumero) / 3;

        System.out.println("O maior número entre os digitados é: " + maior);
        System.out.println("O menor número entre os digitados é: " + menor);
        System.out.println("A média aritmética dos números digitados é: " + media);

    }
}