package aula06.exercicio19;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exe19 {
    public static void main(String[] args) {
        String nomeDigitado;
        Scanner ler = new Scanner(System.in);
        Map<String, Double> notaEstudantes = new HashMap<>();
        notaEstudantes.put("MATHEUS", 10.0);
        notaEstudantes.put("DONATELO", 8.5);
        notaEstudantes.put("MICHELANGELO", 9.0);
        notaEstudantes.put("RAFAEL", 7.8);
        notaEstudantes.put("LEONARDO", 9.7);

        System.out.println("Digite o nome de um(a) aluno(a) e verificarei se ele encontra-se em nossa lista de estudantes.");
        nomeDigitado = ler.next().toUpperCase();

        if (notaEstudantes.containsKey(nomeDigitado)) {
            System.out.println("O aluno " + nomeDigitado + " foi encontrado em nossa lista de alunos! Sua nota é: " + notaEstudantes.get(nomeDigitado) + ".");
        } else {
            System.out.println("O aluno " + nomeDigitado + " não está presente em nossa lista de alunos...");
        }

    }
}
