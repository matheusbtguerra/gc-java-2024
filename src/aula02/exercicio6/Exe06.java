package aula02.exercicio6;
import java.util.Scanner;

public class Exe06 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("------Escrever ao Contrário------");
        System.out.println("Diga sua comida favorita e eu irei deixá-la ao contrário!");
        String comida = ler.next();

        int tamanhoPalavra = 0;
        for (char c : comida.toCharArray()) {
            tamanhoPalavra++;
        }

        for (int i = tamanhoPalavra - 1; i >= 0; i--) {
            System.out.print(comida.charAt(i));
        }
    }
}
