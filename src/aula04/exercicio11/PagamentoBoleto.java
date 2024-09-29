package aula04.exercicio11;

public class PagamentoBoleto implements Pagamento {
    int codigoBoleto;

    public PagamentoBoleto(int codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void processarPagamento() {
        System.out.println("\nPagamento do boleto realizado com sucesso! \nO processamento do pagamento pode levar até 2 dias úteis! \nCÓDIGO DO BOLETO: " + codigoBoleto);
    }
}
