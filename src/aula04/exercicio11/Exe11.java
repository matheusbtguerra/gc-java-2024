package aula04.exercicio11;

public class Exe11 {
    public static void main(String[] args) {
        PagamentoBoleto boleto = new PagamentoBoleto(123);
        PagamentoCartao credito = new PagamentoCartao("Júnior");

        credito.processarPagamento();
        boleto.processarPagamento();
    }
}
