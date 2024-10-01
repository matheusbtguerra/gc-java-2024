package aula06.exercicio18;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;

public class Exe18 {
    public static void main(String[] args) {
        String nomeDigitado;
        Scanner ler = new Scanner(System.in);
        HashSet<String> nomeEstudantes = new HashSet<>();
        nomeEstudantes.add("ANTEDEGUIMON");
        nomeEstudantes.add("RODRIGO");
        nomeEstudantes.add("MATHEUS");
        nomeEstudantes.add("RAFAEL");
        nomeEstudantes.add("ALÍBIO");
        nomeEstudantes.add("ANA");
        nomeEstudantes.add("GABRIELA");
        nomeEstudantes.add("JÉSSICA");
        nomeEstudantes.add("CAROL");

        System.out.println("Digite o nome de um(a) aluno(a) e verificarei se ele encontra-se em nossa lista de estudantes.");
        nomeDigitado = ler.next().toUpperCase();

        if (nomeEstudantes.contains(nomeDigitado)) {
            switch (nomeDigitado){
                case "ANTEDEGUIMON":
                    System.out.println("\n* Tenho um amigo chamado " + nomeDigitado + "!\n@ Qual o nome dele senhor?\n" + "* " + nomeDigitado);
                    break;
                case "MATHEUS":
                    System.out.println("O aluno " +nomeDigitado + " está presente em nossa lista de alunos, e particularmente acho ele um gatinho rsrsrs...");
                    break;
                default:
                    System.out.println("O aluno " + nomeDigitado + " está presente em nossa lista de alunos...");
            }
        } else {
            System.out.println("O aluno " + nomeDigitado + " não está presente em nossa lista de alunos...");
        }



    }
}
