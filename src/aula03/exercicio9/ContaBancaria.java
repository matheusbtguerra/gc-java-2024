package aula03.exercicio9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaBancaria {
    String nome, cpf, banco, endereco;
    double saldo;
    int identificadorConta;
    Date horaAtual = new Date();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(horaAtual);
    String hora = new SimpleDateFormat("HH:mm:ss").format(horaAtual);

    public ContaBancaria(String nome, String cpf, String banco, String endereco, double saldo,int identificadorConta) {

        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.endereco = endereco;
        this.saldo = saldo;
        this.identificadorConta = identificadorConta;
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

    public void verificarInformacoes() {
        System.out.println("\n");
        System.out.println("==========================Informações da Conta==========================");
        System.out.println("* Nome do Titular: " + this.getNome() + ".");
        System.out.println("* CPF do Titular: " + this.getCpf() + ".");
        System.out.println("* Saldo Atual: " + this.getSaldo() + "R$.");
        System.out.println("* Endereço do Titular: " + this.getEndereco() + ".");
        System.out.println("======= *" + this.getBanco() + " - Consulta Realizada em: " + this.getData() + " - " + getHora() + " =======");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdentificadorConta() {
        return identificadorConta;
    }

    public void setIdentificadorConta(int identificadorConta) {
        this.identificadorConta = identificadorConta;
    }

    public Date getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(Date horaAtual) {
        this.horaAtual = horaAtual;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
