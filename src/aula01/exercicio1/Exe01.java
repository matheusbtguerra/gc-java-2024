package aula01.exercicio1;
import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        String nome;

        System.out.println("Olá! Diga seu nome e direi o que acho dele!");
        nome = ler.next();
        if (nome.equals("Matheus") || nome.equals("matheus")){
            System.out.println("Parabéns " + nome + " o seu nome é perfeito!");
        } else {
            System.out.println("Nossa " + nome + "!" + " O seu nome é muito legal!");
        }
    }
}
