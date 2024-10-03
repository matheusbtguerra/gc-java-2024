package aula06.exercicio20;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exe20 {
    public static void main(String[] args) {
        String fraseDigitada;
        Scanner ler = new Scanner(System.in);
        LinkedHashMap<String, Integer> contagemPalavras = new LinkedHashMap<>();

        System.out.println("Digite uma frase para o programa contar quantas palavras e quantas vezes elas são repetidas na frase.");
        fraseDigitada = ler.nextLine();

        String[] palavrasSeparadas = fraseDigitada.split(" ");

        for (int i = 0; i < palavrasSeparadas.length; i++) {
            String palavra = palavrasSeparadas[i];
            if (contagemPalavras.containsKey(palavra)){
                int valorChave = contagemPalavras.get(palavra);
                contagemPalavras.put(palavra, (valorChave = valorChave + 1));
            } else {
                contagemPalavras.put(palavra, 1);
            }
        }

        System.out.println(contagemPalavras);

    }
}
