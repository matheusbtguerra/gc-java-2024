package aula02.exercicio5;
import java.util.Scanner;

public class Exe05 {
    public static void main(String[] args) {
        String palavra;
        Scanner ler = new Scanner(System.in);
        int tamanho = 0;

        System.out.println("------Separador de String------");
        System.out.println("Digite uma palavra para ser separada ao meio.");
        palavra = ler.next();

        for (char c : palavra.toCharArray()) {
            tamanho++;
        }

        int meioPalavra = tamanho / 2;

        for (int i = 0; i < meioPalavra; i++) {
            System.out.print(palavra.charAt(i));
        }
    }
}
