package aula02.exercicio4;
import java.util.Scanner;

public class Exe04 {
        public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            int numeroFinal, numeroInicial;

            System.out.println("-------Números Primos-------");
            System.out.println("Digite o número inicial do intervalo de números primos");
            numeroInicial = ler.nextInt();
            System.out.println("Agora digite o número final do intervalo de números primos");
            numeroFinal = ler.nextInt();

            System.out.println("Os números primos entre " + numeroInicial + " e " + numeroFinal + " são:");
            for (int num = numeroInicial; num <= numeroFinal; num++) {
                boolean primo = true;
                if (num > 2 && num % 2 == 0) {
                    primo = false;
                } else {
                    for (int i = 3; i <= Math.sqrt(num); i += 2) {
                        if (num % i == 0) {
                            primo = false;
                            break;
                        }
                    }
                }
                if (primo) {
                    System.out.println(num);
                }
            }
        }
    }
