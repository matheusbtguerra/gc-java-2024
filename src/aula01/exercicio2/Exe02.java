package aula01.exercicio2;
import java.util.Scanner;

public class Exe02 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int primeiroNumero, segundoNumero;

        System.out.println("-------------Soma de Dois Números-------------");
        System.out.println("Digite o primeiro número da soma: ");
        primeiroNumero = ler.nextInt();
        System.out.println("Digite o segundo número da soma: ");
        segundoNumero = ler.nextInt();

        System.out.println("O resultado de sua soma é " + (primeiroNumero+segundoNumero) + "!");
    }
}
