package aula03.exercicio9;

    //nome (nome do titular da conta)
    //cpf (número de CPF do titular)
    //identificadorConta (número de identificação da conta)
    //banco (nome do banco)
    //endereco (endereço do titular)
    //saldo (saldo disponível na conta)
    //horarioAtual (um atributo para armazenar o horário atual)

//Implemente os seguintes métodos na classe:
    //saque(double valor): Realiza um saque da conta, desde que o saldo seja suficiente. Caso contrário, exibe uma mensagem de erro.
    //deposito(double valor): Realiza um depósito na conta, atualizando o saldo.
    //pix(double valor): Realiza uma transferência PIX. Caso contrário, exibe uma mensagem de erro.
    //transferencia(ContaBancaria destino, double valor):
        // Realiza uma transferência para outra conta bancária, verificando se o horário atual está dentro do intervalo permitido (8hrs às 19hrs) e se o saldo é suficiente.
        // Caso contrário, exibe uma mensagem de erro.
    //verificarSaldo(): Exibe o saldo atual da conta.
    //verificarHorario(): Exibe o horário atual.
    //verificarInformacoes(): Exibe todas as informações da conta bancária, como nome, CPF, saldo, etc.

//Tarefas adicionais:
    //Implemente uma validação no método cpf para garantir que o CPF seja um número válido.
    //Adicione um histórico de transações na conta bancária, registrando todas as operações de saque, depósito, PIX e transferência. Crie um método para exibir o histórico de transações.
    //Crie um construtor para a classe que permita inicializar os atributos iniciais da conta bancária.
    //Implemente um método alterarEndereco(String novoEndereco) para atualizar o endereço do titular da conta.
    //Adicione uma taxa de manutenção mensal à conta bancária, que seja deduzida automaticamente do saldo no primeiro dia de cada mês.
    //Crie um método calcularJuros(double taxa) que calcule juros sobre o saldo da conta e os adicione mensalmente.
    //Implemente um método fecharConta() que encerre a conta, zerando o saldo e não permitindo mais operações.

import aula03.exercicio9.entidade.ContaBancaria;
import aula03.exercicio9.repositorio.ListaDeContasBancarias;
import aula03.exercicio9.utilitario.MenuBancario;

public class Exe09 {
    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria("Alibio", "000.000.000-54", "Santander", "Rua do Caldeira");
        ContaBancaria conta2 = new ContaBancaria("Matheus", "000.000.000-55", "Santander", "Rua do Caldeira");
        ContaBancaria conta3 = new ContaBancaria("Rafael", "000.000.000-56","Banrisul","Rua do Caldeira");

        MenuBancario menuBancario = new MenuBancario();

        menuBancario.menu();

        //


    }
}
