package aula04.exercicio11;

public class PagamentoCartao implements Pagamento {
    String nomeDoTitular;

    public PagamentoCartao(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    @Override
    public void processarPagamento() {
        System.out.println("\nPagamento com cartão de crédito realizado com sucesso! \nO processamento do pagamento é instantâneo! \nNOME DO TITULAR DA CONTA DESTINATÁRIA: " + nomeDoTitular);
    }
}
