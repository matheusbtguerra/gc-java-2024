package aula03.exercicio9.utilitario;

import aula03.exercicio9.entidade.ContaBancaria;
import aula03.exercicio9.repositorio.ListaDeContasBancarias;
import aula03.exercicio9.repositorio.ListaDeTransacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBancario implements Menu {

    private ContaBancaria contaBancaria;
    private Scanner sc = new Scanner(System.in);


    @Override
    public void menu() {

        imprimirMenu("\nCrie sua conta bancária com os dados de: \n\nNome, Cpf, Banco e Endereço.\nDepois realize o depósito inicial\n");
        criarContaBancaria();
        while (true) {
            menuSecundario();
            if (!lidarOpcaoUsuario()) break;
        }
    }

    @Override
    public void menuSecundario() {
        String texto = """
                
                Qual opção você deseja realizar?
                
                1.  Realizar depósito
                2.  Realizar saque
                3.  Realizar transferência
                4.  Realizar PIX
                5.  Informações da conta
                6.  Alterar endereço da conta
                7.  Listar contas do Banco
                8.  Fechar conta
                9.  Listar transações  
                0.  Sair  
                """;
        imprimirMenu(texto);
    }

    private void imprimirMenu(String texto) {
        System.out.println("=".repeat(45));
        System.out.println(texto);
        System.out.println("=".repeat(45));
    }

    private void criarContaBancaria() {
        System.out.println();
        String nome = obterInputString("Nome completo: ");
        String cpf = obterInputString("CPF: ");
        String endereco = obterInputString("Endereço: ");
        String banco = obterInputString("Banco: ");

        contaBancaria = new ContaBancaria(nome, cpf, endereco, banco);
        double saldoInicial = obterInputDouble("Digite o valor do depósito: ");
        contaBancaria.deposito(saldoInicial);
    }

    private double obterInputDouble(String prompt) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextDouble();
                sc.nextLine(); // Limpar o buffer
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, insira um número válido.");
                sc.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    private String obterInputString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private boolean lidarOpcaoUsuario() {
        String opcao;
        while (true) {
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    contaBancaria.deposito(obterInputDouble("Digite o valor do depósito: "));
                    break;
                case "2":
                    contaBancaria.saque(obterInputDouble("Digite o valor do saque: "));
                    break;
                case "3":
                    realizarTransferencia();
                    break;
                case "4":
                    realizarPix();
                    break;
                case "5":
                    contaBancaria.mostrarInformacoes();
                    break;
                case "6":
                    contaBancaria.alterarEndereco();
                    break;
                case "7":
                    ListaDeContasBancarias.getInstancia().mostrarInformacoesParciais();
                    break;
                case "8":
                    ListaDeContasBancarias.getInstancia().removerConta(contaBancaria.getIdentificadorConta());
                    contaBancaria.encerrarConta();
                    break;
                case "9":
                    ListaDeTransacao.getInstancia().listarTransacoes();
                    break;

                case "0":
                    System.out.println("Até logo!");
                    return false;
                default:
                    System.out.println("Digite uma opção válida");
            }
            return true;
        }
    }

    private void realizarTransferencia() {
        System.out.printf("O valor da taxa de transferência é de %.2f %n", contaBancaria.getTaxaDeTransferencia());
        int numeroDaConta = obterNumeroDaConta();
        if (numeroDaConta != -1) {
            ContaBancaria contaBancariaDestino = ListaDeContasBancarias.getInstancia().procurarConta(numeroDaConta);
            if (contaBancariaDestino != null && contaBancariaDestino.getIdentificadorConta() != contaBancaria.getIdentificadorConta()) {
                double valor = obterInputDouble("Digite o valor da transferência: ");
                contaBancaria.transferencia(contaBancariaDestino, valor);
            } else {
                System.out.println("Conta inválida");
            }
        }
    }

    private void realizarPix() {
        int numeroDaConta = obterNumeroDaConta();
        if (numeroDaConta != -1) {
            ContaBancaria contaBancariaDestino = ListaDeContasBancarias.getInstancia().procurarConta(numeroDaConta);
            if (contaBancariaDestino != null && contaBancariaDestino.getIdentificadorConta() != contaBancaria.getIdentificadorConta()) {
                double valor = obterInputDouble("Digite o valor do PIX: ");
                contaBancaria.realizarPix(contaBancariaDestino, valor);
            } else {
                System.out.println("Conta inválida");
            }
        }
    }

    private int obterNumeroDaConta() {
        String opcao = obterInputString("Digite o número da conta ou 'L' para listar contas: ");
        if (opcao.equalsIgnoreCase("L")) {
            ListaDeContasBancarias.getInstancia().mostrarInformacoesParciais();
            return obterNumeroDaConta();
        }
        try {
            return Integer.parseInt(opcao);
        } catch (NumberFormatException e) {
            System.out.println("Número da conta inválido");
            return -1;
        }
    }
}
