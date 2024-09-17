package aula03.exercicio9;

public class Exe09 {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria("Alibio", "000.000.000-54","Santander","Rua do Caldeira",500, 1);
        System.out.println(conta.getSaldo());
        conta.saque(300);
        System.out.println(conta.getSaldo());
        conta.deposito(500);
        System.out.println(conta.getSaldo());
        conta.verficarHorario();
        conta.verificarSaldo();
        conta.verificarInformacoes();
    }
}
