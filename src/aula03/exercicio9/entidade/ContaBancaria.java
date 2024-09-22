package aula03.exercicio9.entidade;

import aula03.exercicio9.repositorio.ListaDeContasBancarias;
import aula03.exercicio9.repositorio.ListaDeTransacao;
import aula03.exercicio9.utilitario.DataUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ContaBancaria {

    private String nome, cpf, banco, endereco;
    private double saldo;
    private static int contadorContas = 1;
    private final int identificadorConta;
    private boolean valorizadoHoje = false;
    private boolean cobradoHoje = false;
    private boolean ativo = false;
    private final double taxaDeTransferencia = 5.99;

    public ContaBancaria(String nome, String cpf, String banco, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.endereco = endereco;
        this.identificadorConta = contadorContas++;
        ativo = true;
        registrarContaNaLista(this);
    }

    private void valorizarSaldoDiaCinco(double taxa) {
        LocalDate dataAtual = obterDataAtual();
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

    private void cobrancaMensal() {
        LocalDate dataAtual = obterDataAtual();
        int taxaMensal = 15;
        if (dataAtual.getDayOfMonth() == 1 && !cobradoHoje) {
            saldo -= taxaMensal;
            cobradoHoje = true; // Garantindo que a cobrança não seja feita novamente
            System.out.println("\nTaxa mensal de uso cobrada com sucesso!");
        }
    }

    private void reajustesMensais() {
        cobrancaMensal();
        valorizarSaldoDiaCinco();
    }

    public void verificarSaldo() {
        reajustesMensais();
        System.out.println("\n============================Consulta de Saldo===========================");
        System.out.printf("\nOlá %s! O saldo disponível em sua conta é de R$%.2f.", nome, saldo);
        mostrarInformacoes();
    }

    public void verficarHorario() {
        LocalDate dataAtual = obterDataAtual();
        LocalTime horaAtual = obterHoraAtual();
        System.out.println("\nOlá " + nome + "! As datas e horas atuais são " + DataUtils.formatData(dataAtual) + " - " + DataUtils.formatHora(horaAtual));
    }

    public void mostrarInformacoes() {
        reajustesMensais();
        System.out.println("\n==========================Informações da Conta===========================");
        System.out.println("* Número da conta: " + identificadorConta + ".");
        System.out.println("* Nome do Titular: " + nome + ".");
        System.out.println("* CPF do Titular: " + cpf + ".");
        System.out.printf("* Saldo Atual: R$%.2f.%n", saldo);
        System.out.println("* Endereço do Titular: " + endereco + ".");
        System.out.println(!ativo ? "* Conta encerrada! " : "* Conta ativa");
        momentoConsulta();
    }

    public void mostrarInformacoesParciais() {
        System.out.println("\n==========================Informações da Conta===========================");
        System.out.println("* Número da conta: " + identificadorConta + ".");
        System.out.println("* Nome do Titular: " + nome + ".");
    }

    public void deposito(double valor) {
        if (!ativo) {
            System.out.println("Conta encerrada. Não é possível realizar depósitos.");
            return;
        }
        reajustesMensais();
        if (valor > 0) {
            saldo += valor;
            System.out.println("\n================================Deposito================================");
            System.out.println("\nDeposito no valor de R$" + valor + " realizado com sucesso.");
            System.out.printf("Saldo atual de: R$%.2f.%n", saldo);
            momentoConsulta();
            registrarTransacao(Descricao.DEPOSITO, valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void saque(double valor) {
        if (!ativo) {
            System.out.println("Conta encerrada. Não é possível realizar saques.");
            return;
        }
        reajustesMensais();
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("\n================================Saque================================");
            System.out.println("\nSaque no valor de R$" + valor + " realizado com sucesso! Seu saldo atual é de: R$" + saldo + ".");
            momentoConsulta();
            registrarTransacao(Descricao.SAQUE, valor);
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido para saque.");
        }
    }

    public void transferencia(ContaBancaria destino, double valor) {
        if (!ativo) {
            System.out.println("Conta encerrada. Não é possível realizar transferências.");
            return;
        }
        reajustesMensais();
        LocalTime horaAbertura = LocalTime.of(8, 0, 0);
        LocalTime horaFechamento = LocalTime.of(19, 0, 0);
        LocalTime horaAtual = obterHoraAtual();
        if (horaAtual.isAfter(horaAbertura) && horaAtual.isBefore(horaFechamento)) {
            double taxaDeTransferencia = 5.99;

            if (valor > 0 && saldo >= (valor + taxaDeTransferencia)) {
                saldo -= (valor + taxaDeTransferencia);
                destino.saldo += valor;
                System.out.printf("\nTransferência no valor de R$%.2f realizada com sucesso para %s.%n", valor, destino.nome);
                registrarTransacao(Descricao.TRANSFERENCIA, valor);
            } else {
                System.out.println("\nSaldo insuficiente ou valor inválido para transferência.");
            }
        } else {
            System.out.println("\nDesculpe, estamos fora do horário de funcionamento de transferências bancárias. Nosso horário de funcionamento está entre 8h e 19h.");
        }
    }

    public void realizarPix(ContaBancaria destino, double valor) {
        if (!ativo) {
            System.out.println("Conta encerrada. Não é possível realizar PIX.");
            return;
        }
        reajustesMensais();
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.saldo += valor;
            System.out.printf("\nPix no valor de R$%.2f realizado com sucesso para %s.%n", valor, destino.nome);
            registrarTransacao(Descricao.PIX, valor);
        } else {
            System.out.println("\nSaldo insuficiente ou valor inválido para Pix.");
        }
    }

    public void alterarEndereco() {
        reajustesMensais();
        Scanner ler = new Scanner(System.in);

        System.out.println("\n============================Alterar Endereço============================");
        System.out.println("Olá " + nome + " o seu endereço atual é: " + endereco + ".");
        System.out.print("Digite o seu novo endereço: ");
        endereco = ler.nextLine();
        System.out.println("Endereço atualizado com sucesso! Endereço atual: " + endereco + ".");
        momentoConsulta();
    }

    public void encerrarConta() {
        this.ativo = false; // Define a conta como inativa
        System.out.println("Conta encerrada com sucesso.");
    }

    private void momentoConsulta() {
        LocalDate dataAtual = obterDataAtual();
        LocalTime horaAtual = obterHoraAtual();
        System.out.printf("\n======= *%s - Consulta Realizada em: %s - %s =======", banco, DataUtils.formatData(dataAtual), DataUtils.formatHora(horaAtual));
    }

    private LocalDate obterDataAtual() {
        return LocalDate.now();
    }

    private LocalTime obterHoraAtual() {
        return LocalTime.now();
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

    public double getTaxaDeTransferencia() {
        return taxaDeTransferencia;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", banco='" + banco + '\'' + ", endereco='" + endereco + '\'' + ", saldo=" + saldo + ", identificadorConta=" + identificadorConta + '}';
    }
}
