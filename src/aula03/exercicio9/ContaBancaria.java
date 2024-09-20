package aula03.exercicio9;

import aula03.exercicio9.utilitarios.DataUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ContaBancaria {

    private String nome, cpf, banco, endereco;
    private double saldo;
    private LocalDate dataAtual = LocalDate.now();
    private LocalTime horaAtual = LocalTime.now();
    private String data = DataUtils.formatData(dataAtual);
    private String hora = DataUtils.formatHora(horaAtual);
    private static int contadorContas = 1;
    private final int identificadorConta;
    private boolean valorizadoHoje = false;

    public ContaBancaria(String nome, String cpf, String banco, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.endereco = endereco;
        this.identificadorConta = contadorContas++;
        registrarContaNaLista(this);
    }

    private void valorizarSaldoDiaCinco(double taxa) {
        if (dataAtual.getDayOfMonth() == 5) {
            if (saldo <= 0) {
                System.out.println("\nNão foi possivel valorizar o saldo, pois você está com o saldo de R$" + saldo);
            } else if (!valorizadoHoje) {
                saldo += saldo * taxa;
                System.out.printf("\nValorização de %.2f%% aplicada com sucesso. Novo saldo: R$%.2f.%n", taxa * 100, saldo);
                registrarTransacao(Descricao.VALORIZACAO, saldo * taxa);
                valorizadoHoje = true;
            } else {
                System.out.println("\nA valorização mensal já foi aplicada hoje.");
            }
        } else {
            System.out.println("\nHoje não é dia 5. Nenhuma valorização foi aplicada.");
        }
    }

    private void valorizarSaldoDiaCinco() {
        valorizarSaldoDiaCinco(0.01);
    }

    private void registrarTransacao(Descricao descricao, double valor) {
        Transacao novaTransacao = new Transacao(descricao, this, valor);
        ListaDeTransacao.getInstancia().adicionarTransacao(novaTransacao);
    }

    private void registrarContaNaLista(ContaBancaria contaBancaria) {
        ListaDeContasBancarias.getInstancia().adicionarConta(contaBancaria);
    }

    public void verificarSaldo() {
        valorizarSaldoDiaCinco();
        System.out.println("\n============================Consulta de Saldo===========================");
        System.out.println("Olá " + nome + "! O saldo disponível em sua conta é de " + saldo + "R$.");
        System.out.println("======= *" + banco + " - Consulta Realizada em: " + data + " - " + hora + "======");
    }

    public void verficarHorario() {
        System.out.println("\nOlá " + nome + "! As datas e horas atuais são " + data + " - " + hora);
    }

    public void mostrarInformacoes() {
        valorizarSaldoDiaCinco();
        System.out.println("\n==========================Informações da Conta===========================");
        System.out.println("* Número da conta: " + identificadorConta + ".");
        System.out.println("* Nome do Titular: " + nome + ".");
        System.out.println("* CPF do Titular: " + cpf + ".");
        System.out.println("* Saldo Atual: " + saldo + "R$.");
        System.out.println("* Endereço do Titular: " + endereco + ".");
        momentoConsulta();
    }

    public void deposito(double valor) {
        valorizarSaldoDiaCinco();
        if (valor > 0) {
            saldo += valor;
            System.out.println("\n================================Deposito================================");
            System.out.println("Deposito no valor de " + valor + "R$" + " realizado com sucesso.");
            System.out.println("======= *" + banco + " - Depósito Realizado em: " + data + " - " + hora + " =======");
            registrarTransacao(Descricao.DEPOSITO, valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void saque(double valor) {
        valorizarSaldoDiaCinco();
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("\n================================Saque================================");
            System.out.println("Saque no valor de " + valor + "R$" + " realizado com sucesso! Seu saldo atual é de: " + getSaldo() + "R$.");
            System.out.println("======= *" + banco + " - Consulta Realizada em: " + data + " - " + hora + " =======");
            registrarTransacao(Descricao.SAQUE, valor);
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido para saque.");
        }
    }

    public void transferencia(ContaBancaria destino, double valor) {
        valorizarSaldoDiaCinco();
        double taxaDeTransferencia = 5.99;
        if (valor > 0 && saldo >= (valor + taxaDeTransferencia)) {
            saldo -= (valor + taxaDeTransferencia);
            destino.saldo += valor;
            System.out.printf("\nTransferência no valor de R$%.2f realizada com sucesso para a conta %d.%n", valor, destino.getIdentificadorConta());
            registrarTransacao(Descricao.TRANSFERENCIA, valor);
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido para transferência.");
        }
    }

    public void realizarPix(ContaBancaria destino, double valor) {
        valorizarSaldoDiaCinco();
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.saldo += valor;
            System.out.printf("\nPix no valor de R$%.2f realizado com sucesso para a conta %d.%n", valor, destino.getIdentificadorConta());
            registrarTransacao(Descricao.PIX, valor);
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido para Pix.");
        }
    }

    public void alterarEndereco() {
        valorizarSaldoDiaCinco();
        Scanner ler = new Scanner(System.in);

        System.out.println("\n============================Alterar Endereço============================");
        System.out.println("Olá " + nome + " o seu endereço atual é " + endereco + ".");
        System.out.print("Digite o seu novo endereço: ");
        endereco = ler.nextLine();
        System.out.println("Endereço atualizado com sucesso! Endereço atual: " + endereco + ".");
        momentoConsulta();
    }

    private void momentoConsulta () {
        System.out.println("======= *" + banco + " - Consulta Realizada em: " + data + " - " + hora + "=======");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getBanco() {
        return banco;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getIdentificadorConta() {
        return identificadorConta;
    }

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
               "nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", banco='" + banco + '\'' +
               ", endereco='" + endereco + '\'' +
               ", saldo=" + saldo +
               ", identificadorConta=" + identificadorConta +
               '}';
    }
}
