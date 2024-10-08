package aula07.exercicio24;

import aula07.exercicio22.ValorInvalidoException;

import java.util.Scanner;

import static java.lang.Double.isNaN;

public class Exe24 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        try {
            System.out.println("---------Verificador de frases---------");
            System.out.println("Digite uma frase: ");
            String fraseDigitada = ler.nextLine();
            boolean continuar = true;

            while (continuar) {
                System.out.println("Digite uma opção: ");
                System.out.println("A - Converter a string para um número inteiro");
                System.out.println("B - Verificar se a string está nula ou vazia");
                System.out.println("C - Pegar o caractere numa posição específica da string");
                System.out.println("D - Verificar se a frase \"java é fácil\" existe na frase digitada");
                System.out.println("E - Sair");
                String option = toUpperCase(ler.next());

                try {
                    switch (option) {
                        case "A" -> {
                            if (isInteger(fraseDigitada)) {
                                int numero = Integer.parseInt(fraseDigitada);
                                System.out.println("\nO número inteiro é: " + numero);
                            } else {
                                throw new NumberFormatException("A frase digitada não é um número inteiro válido.");
                            }
                        }
                        case "B" -> {
                            if (fraseDigitada == null || fraseDigitada.isEmpty() || isStringBranca(fraseDigitada)) {
                                throw new NullPointerException("A frase digitada é nula, vazia ou está em branco!");
                            } else {
                                System.out.println("A frase digitada não é nula, vazia ou está em branco!");
                            }
                        }
                        case "C" -> {
                            int fraseSize = fraseDigitada.length();
                            System.out.println("Digite o índice do caractere que deseja acessar (entre 0 - " + (fraseSize - 1) + "): ");
                            int stringIndex = ler.nextInt();
                            if (stringIndex >= fraseSize || stringIndex < 0) {
                                throw new StringIndexOutOfBoundsException("O índice digitado é inválido! Deve estar entre 0 e " + (fraseSize - 1));
                            } else {
                                char caractere = fraseDigitada.charAt(stringIndex);
                                if (caractere == ' ') {
                                    System.out.println("O caractere selecionado é vazio, selecione outro!");
                                } else {
                                    System.out.println("O caractere selecionado foi o: " + caractere);
                                }
                            }
                        }
                        case "D" -> {
                            String fraseToFind = "JAVA é FáCIL";
                            fraseDigitada = toUpperCase(fraseDigitada);
                            if (fraseDigitada.contains(toUpperCase(fraseToFind))) {
                                throw new CaldeiraException("Java não é fácil, pequeno maldito!");
                            } else {
                                System.out.println("A frase \"" + fraseToFind + "\" não foi encontrada no texto digitado.");
                            }
                        }
                        case "E" -> {
                            continuar = false;
                            System.out.println("Saindo do programa...");
                        }
                        default -> {
                            System.out.println("Opção não encontrada, digite novamente!");
                        }
                    }
                } catch (NullPointerException | IllegalArgumentException | StringIndexOutOfBoundsException |
                         CaldeiraException e) {
                    System.out.println("\nErro: " + e.getMessage());
                }
            }
        } finally {
            System.out.println("\n-------Frase verificada com sucesso!-------");
            System.out.println
                    (
                            "Um dia, um paraquedista experiente pulou de um avião e acabou pousando em uma ilha desconhecida de um arquipélago. Ao chegar, começou a ouvir sons de instrumentos e se deu conta de que havia entrado em território indígena.\n" +
                                    "Assustado, ele tentou fugir, gritando para o céu: \"Estou ferrado!\". \n" +
                                    "Então, uma voz misteriosa respondeu: \"Calma, meu filho, você não está ferrado!\".\n" +
                                    "Surpreso, o paraquedista perguntou: \"O que eu faço?\".\n" +
                                    "A voz disse: \"Pegue aquela grande pedra e acerte bem na testa do cacique!\".\n" +
                                    "Sem pensar duas vezes, ele fez o que a voz pediu e acertou a pedra bem no centro da testa do cacique. A tribo ficou enfurecida e começou a gritar.\n" +
                                    "Desesperado, o aventureiro correu novamente e, ofegante, perguntou para a voz: \"E agora?\".\n" +
                                    "A voz respondeu: \"Agora sim, você está ferrado!\"."
                    );
        }
    }
    public static boolean isStringBranca(String frase) {
        boolean emBranco = true;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != ' ') {
                emBranco = false;
                break;
            }
        }
        return emBranco;
    }
    public static String toUpperCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - ('a' - 'A')); // Diferença de 32, número padrão de diferença entre char minusculo e maiusculo
            }
            result.append(c);
        }
        return result.toString();
    }
    private static boolean isInteger(String frase) {
        if (frase == null || frase.isEmpty() || isStringBranca(frase)) {
            return false;
        }
        try {
            Integer.parseInt(frase);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
