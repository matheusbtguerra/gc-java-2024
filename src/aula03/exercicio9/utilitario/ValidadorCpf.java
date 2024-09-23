package aula03.exercicio9.utilitario;

public class ValidadorCpf {
    private static final int PONTEIRO = 2;

    public static boolean cpfValido(String cpf) {

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Digite um CPF com 11 dígitos");
        }

        // Verifica se o CPF é uma sequência de números repetidos (ex: "11111111111")
        boolean todosDigitosIguais = true;
        char primeiroChar = cpf.charAt(0);
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiroChar) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int soma = primeiroNumero(cpf);
        int resto = soma % 11;
        int primeiroDigito = (resto >= 2) ? (11 - resto) : 0;

        // Cálculo do segundo dígito verificador
        int somaSegundoNum = segundoNumero(cpf, primeiroDigito);
        int resto2 = somaSegundoNum % 11;
        int segundoDigito = (resto2 >= 2) ? (11 - resto2) : 0;

        return cpf.charAt(9) == Character.forDigit(primeiroDigito, 10) && cpf.charAt(10) == Character.forDigit(segundoDigito, 10);
    }

    private static int primeiroNumero(String cpf) {
        int ponteiro = PONTEIRO;
        int soma = 0;
        for (int i = cpf.length() - 3; i >= 0; i--) {
            int multiplicaNum = Character.getNumericValue(cpf.charAt(i)) * ponteiro;
            ponteiro++;
            soma += multiplicaNum;
        }
        return soma;
    }

    private static int segundoNumero(String cpf, int primeiroDigito) {
        boolean primeiraIteracao = true;
        int multiplicaNum;
        int ponteiro = PONTEIRO;
        int soma = 0;

        for (int i = cpf.length() - 2; i >= 0; i--) {
            if (primeiraIteracao) {
                primeiraIteracao = false;
                multiplicaNum = ponteiro * primeiroDigito;
                soma += multiplicaNum;
                ponteiro++;
            } else {
                multiplicaNum = Character.getNumericValue(cpf.charAt(i)) * ponteiro;
                soma += multiplicaNum;
                ponteiro++;
            }
        }
        return soma;
    }
}

// Referência para o cálculo
// https://www.macoratti.net/alg_cpf.htm
