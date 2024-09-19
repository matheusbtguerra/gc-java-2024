package aula03.exercicio9;

public class Exe09 {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria("Alibio", "000.000.000-54", "Santander", "Rua do Caldeira");
        ContaBancaria conta1 = new ContaBancaria("Matheus", "000.000.000-54", "Santander", "Rua do Caldeira");

        conta1.deposito(500.00);
        conta1.saque(100.00);
        conta1.transferencia(conta, 200.00);
        conta1.realizarPix(conta, 50.00);

        conta1.mostrarInformacoes();
        conta.mostrarInformacoes();

        ListaDeTransacao.getInstancia().listarTransacoes();
    }
}
