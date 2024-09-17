package aula02.exercicio4;
import java.util.Scanner;

public class Exe04 {
        public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            int numeroComparativo;

            System.out.println("-------Números Primos-------");
            System.out.println("Digite até que número você deseja ver os primos existentes.");
            numeroComparativo = ler.nextInt();

            for (int num = 2; num <= numeroComparativo; num++) {
                boolean Primo = true;

                if (num > 2 && num % 2 == 0) {
                    Primo = false;
                } else {
                    for (int i = 3; i <= Math.sqrt(num); i += 2) {
                        if (num % i == 0) {
                            Primo = false;
                            break;
                        }
                    }
                }
                if (Primo) {
                    System.out.println(num + " É primo!");
                }
            }
        }
    }
