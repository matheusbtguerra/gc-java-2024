package aula03.exercicio9;

import aula03.exercicio9.utilitarios.DataUtils;

import java.util.Date;

public class ContaBancaria {

    private String nome, cpf, banco, endereco;
    private double saldo;
    private Date horaAtual = new Date();
    private String data = DataUtils.formatData(horaAtual);
    private String hora = DataUtils.formatHora(horaAtual);
    private static int contadorContas = 1;
    private int identificadorConta;

    public ContaBancaria(String nome, String cpf, String banco, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.endereco = endereco;
        this.identificadorConta = contadorContas++;
        this.saldo = saldo;
    }

    public void saque (double valor) {
        double saldo = this.getSaldo();
        if (saldo >= valor) {
            setSaldo(saldo-valor);
            System.out.println("\n");
            System.out.println("================================Saque================================");
            System.out.println("Saque no valor de " + valor + "R$" + " realizado com sucesso! Seu saldo atual é de: " + getSaldo() + "R$.");
            System.out.println("======= *" + this.getBanco() + " - Saque Realizado em: " + this.getData() + " - " + getHora() + " =======");
        }
        else {
            System.out.println("\n");
            System.out.println("=======================================Saque=======================================");
            System.out.println("Ops! Saldo insuficiente para a operação. Seu saldo atual é de: " + saldo + "R$.");
            System.out.println("======= *" + this.getBanco() + " - Tentativa de Saque Realizada em: " + this.getData() + " - " + getHora() + " =======");
        }
    }

    public void deposito (int valor) {
        double saldo = getSaldo();
        this.setSaldo(saldo + valor);
        System.out.println("\n");
        System.out.println("================================Deposito================================");
        System.out.println("Deposito no valor de " + valor + "R$" + " realizado com sucesso.");
        System.out.println("======= *" + this.getBanco() + " - Depósito Realizado em: " + this.getData() + " - " + getHora() + " =======");
    }

    public void pix(ContaBancaria desitno, double valor) {

    }

    public void trasnferencia(ContaBancaria destino, double valor) {


    }

    public void verificarSaldo() {
        System.out.println("\n");
        System.out.println("============================Consulta de Saldo============================");
        System.out.println("Olá " + this.getNome() + "! O saldo disponível em sua conta é de " + this.getSaldo() + "R$.");
        System.out.println("======= *" + this.getBanco() + " - Consulta Realizada em: " + this.getData() + " - " + getHora() + " =======");
    }

    public void verficarHorario() {
        System.out.println("\n");
        System.out.println("Olá " + this.getNome() + "! As datas e horas atuais são " + this.getData() + " - " + this.getHora());
    }

    public void mostrarInformacoes() {
        System.out.println("\n");
        System.out.println("==========================Informações da Conta==========================");
        System.out.println("* Número da conta: " + this.getIdentificadorConta() + ".");
        System.out.println("* Nome do Titular: " + this.getNome() + ".");
        System.out.println("* CPF do Titular: " + this.getCpf() + ".");
        System.out.println("* Saldo Atual: " + this.getSaldo() + "R$.");
        System.out.println("* Endereço do Titular: " + this.getEndereco() + ".");
        System.out.println("======= *" + this.getBanco() + " - Consulta Realizada em: " + this.getData() + " - " + getHora() + " =======");
    }

    public void deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("\n");
            System.out.println("================================Deposito================================");
            System.out.println("Deposito no valor de " + valor + "R$" + " realizado com sucesso.");
            System.out.println("======= *" + banco + " - Depósito Realizado em: " + data + " - " + hora + " =======");
            registrarTransacao(Descricao.DEPOSITO, valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void saque(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("\n");
            System.out.println("================================Saque================================");
            System.out.println("Saque no valor de " + valor + "R$" + " realizado com sucesso! Seu saldo atual é de: " + getSaldo() + "R$.");
            System.out.println("======= *" + this.getBanco() + " - Consulta Realizada em: " + data + " - " + hora + " =======");
            registrarTransacao(Descricao.SAQUE, valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void transferencia(ContaBancaria destino, double valor) {
        double taxaDeTransferencia = 5.99;

        if (valor > 0 && saldo >= (valor + taxaDeTransferencia)) {
            saldo -= (valor + taxaDeTransferencia);
            destino.saldo += valor;
            System.out.printf("Transferência no valor de R$%.2f realizada com sucesso para a conta %d.%n", valor, destino.getIdentificadorConta());
            registrarTransacao(Descricao.TRANSFERENCIA, valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    public void realizarPix(ContaBancaria destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.saldo += valor;
            System.out.printf("Pix no valor de R$%.2f realizado com sucesso para a conta %d.%n", valor, destino.getIdentificadorConta());
            registrarTransacao(Descricao.PIX, valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para Pix.");
        }
    }

    private void registrarTransacao(Descricao descricao, double valor) {
        Transacao novaTransacao = new Transacao(descricao, this, valor);
        ListaDeTransacao.getInstancia().adicionarTransacao(novaTransacao);
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
        return "ContaBancaria{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", banco='" + banco + '\'' + ", endereco='" + endereco + '\'' + ", saldo=" + saldo + ", identificadorConta=" + identificadorConta;
    }
}
