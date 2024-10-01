package aula06.exercicio16;

import aula06.exercicio15.NivelAcesso;

public class Exe16 {
    public static void main(String[] args) {
        mostrarStatus(StatusPedido.PENDENTE);
        mostrarStatus(StatusPedido.PROCESSANDO);
        mostrarStatus(StatusPedido.ENVIANDO);
        mostrarStatus(StatusPedido.ENTREGUE);
    }
    public static void mostrarStatus(StatusPedido tipo) {
        switch (tipo) {
            case PENDENTE:
                System.out.println("\nO status do seu pedido é: PENDENTE. \nApós o pagamento do pedido ele será processado pelo sistema");
                break;
            case PROCESSANDO:
                System.out.println("\nO status do seu pedido é: PROCESSANDO. \nApós o processamento do pedido ele será enviado.");
                break;
            case ENVIANDO:
                System.out.println("\nO status do seu pedido é: ENVIANDO. \nApós o envio do pedido ele será entregue no endereço indicado no pedido.");
                break;
            default:
                System.out.println("\nO status do seu pedido é: ENTREGUE. \nUHUUUUL! O seu pedido já foi entregue no endereço indicado no pedido.");
                break;
        }
    }
}
