package bossMundo01;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoMercenarios {
    public static void main(String[] args) {
        List<Mercenario> listaMercenarios = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        int opcaoMenuPrincipal;
        boolean saida = false;

        do {
            System.out.println("\n-------Sistema de Gerenciamento de Mercenários-------");
            System.out.println("1. Adicionar Mercenário");
            System.out.println("2. Atualizar Mercenário");
            System.out.println("3. Remover Mercenário");
            System.out.println("4. Listar Mercenários");
            System.out.println("5. Buscar Mercenário por Nome");
            System.out.println("6. Filtrar Mercenários por Classe");
            System.out.println("7. Sair");
            System.out.println("Escolha Uma Opção: ");
            opcaoMenuPrincipal = ler.nextInt();
            ler.nextLine();

            switch (opcaoMenuPrincipal) {
                case 1 -> {
                    System.out.println("Nome do Mercenário: ");
                    String nome = ler.nextLine();

                    System.out.println("Idade: ");
                    int idade = ler.nextInt();
                    while (idade <= 0) {
                        System.out.println("Digite uma idade maior do que 0!");
                        idade = ler.nextInt();
                    }

                    System.out.println("Classe: ");
                    System.out.println("1. Cavaleiro");
                    System.out.println("2. Arqueiro");
                    System.out.println("3. Mago");
                    System.out.println("4. Assassino");
                    int opcaoClasse = ler.nextInt();
                    while (opcaoClasse < 1 || opcaoClasse > 4) {
                        System.out.println("Digite uma opção de classe válida!");
                        opcaoClasse = ler.nextInt();
                    }
                    String classe = switch (opcaoClasse) {
                        case 1 -> "Cavaleiro";
                        case 2 -> "Arqueiro";
                        case 3 -> "Mago";
                        case 4 -> "Assassino";
                        default -> "";
                    };


                    System.out.println("Salário Base: ");
                    int salarioBase = ler.nextInt();
                    while (salarioBase < 0) {
                        System.out.println("Digite um salário base válido!");
                        salarioBase = ler.nextInt();
                    }

                    System.out.println("Avaliação de Desempenho (1-5): ");
                    int avaliacaoDesempenho = ler.nextInt();
                    while (avaliacaoDesempenho < 1 || avaliacaoDesempenho > 5) {
                        System.out.println("Digite uma avaliação de desempenho válida!");
                        avaliacaoDesempenho = ler.nextInt();
                    }

                    Mercenario mercenario = new Mercenario(nome, classe, idade, salarioBase, avaliacaoDesempenho);
                    listaMercenarios.add(mercenario);
                    System.out.println("-------Mercenário adicionado com sucesso!-------");

                }

                case 2 -> {
                    System.out.print("Digite o nome do mercenário a ser atualizado: ");
                    String nomeAtualizar = ler.nextLine();
                    boolean encontrado = false;

                    for (Mercenario m : listaMercenarios) {
                        if (m.getNome().equalsIgnoreCase(nomeAtualizar)) {
                            encontrado = true;
                            System.out.print("Novo Nome: ");
                            String novoNome = ler.nextLine();
                            m.setNome(novoNome);

                            System.out.println("Idade: ");
                            int novaIdade = ler.nextInt();
                            while (novaIdade <= 0) {
                                System.out.println("Digite uma idade maior do que 0!");
                                novaIdade = ler.nextInt();
                            }
                            m.setIdade(novaIdade);

                            System.out.println("Classe: ");
                            System.out.println("1. Cavaleiro");
                            System.out.println("2. Arqueiro");
                            System.out.println("3. Mago");
                            System.out.println("4. Assassino");
                            int opcaoClasse = ler.nextInt();
                            while (opcaoClasse < 1 || opcaoClasse > 4) {
                                System.out.println("Digite uma opção de classe válida!");
                                opcaoClasse = ler.nextInt();
                            }
                            String novaClasse = switch (opcaoClasse) {
                                case 1 -> "Cavaleiro";
                                case 2 -> "Arqueiro";
                                case 3 -> "Mago";
                                case 4 -> "Assassino";
                                default -> "";
                            };
                            m.setClasse(novaClasse);

                            System.out.println("Salário Base: ");
                            int novoSalarioBase = ler.nextInt();
                            while (novoSalarioBase < 0) {
                                System.out.println("Digite um salário base válido!");
                                novoSalarioBase = ler.nextInt();
                            }
                            m.setSalarioBase(novoSalarioBase);

                            System.out.println("Avaliação de Desempenho (1-5): ");
                            int novaAvaliacaoDesempenho = ler.nextInt();
                            while (novaAvaliacaoDesempenho < 1 || novaAvaliacaoDesempenho > 5) {
                                System.out.println("Digite uma avaliação de desempenho válida!");
                                novaAvaliacaoDesempenho = ler.nextInt();
                            }
                            m.setAvaliacaoDesempenho(novaAvaliacaoDesempenho);

                            System.out.println("Mercenário atualizado com sucesso!");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Mercenário não encontrado.");
                    }
                }

                case 3 -> {
                    System.out.print("Digite o nome do mercenário a ser removido: ");
                    String nomeRemover = ler.nextLine();
                    boolean encontrado = false;

                    for (Mercenario m : listaMercenarios) {
                        if (m.getNome().equalsIgnoreCase(nomeRemover)) {
                            encontrado = true;

                            listaMercenarios.remove(m);
                            System.out.println("Mercenário removido com sucesso!");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Mercenário não encontrado.");
                    }
                }

                case 4 -> {
                    System.out.println("Lista de Mercenários:");
                    for (Mercenario m : listaMercenarios) {
                        System.out.println(m.toString());
                    }
                }

                case 5 -> {
                    System.out.print("Digite o nome do mercenário a ser buscado: ");
                    String nomeBuscado = ler.nextLine();
                    boolean encontrado = false;

                    for (Mercenario m : listaMercenarios) {
                        if (m.getNome().equalsIgnoreCase(nomeBuscado)) {
                            encontrado = true;
                            System.out.println(m.toString());
                        }
                        break;
                    }

                    if (!encontrado) {
                        System.out.println("Mercenário não encontrado.");
                    }
                }

                case 6 -> {
                    System.out.print("Digite a classe a ser buscada: ");
                    System.out.println("Classe: ");
                    System.out.println("1. Cavaleiro");
                    System.out.println("2. Arqueiro");
                    System.out.println("3. Mago");
                    System.out.println("4. Assassino");
                    int opcaoClasse = ler.nextInt();
                    while (opcaoClasse < 1 || opcaoClasse > 4) {
                        System.out.println("Digite uma opção de classe válida!");
                        opcaoClasse = ler.nextInt();
                    }
                    String classeBuscada = switch (opcaoClasse) {
                        case 1 -> "Cavaleiro";
                        case 2 -> "Arqueiro";
                        case 3 -> "Mago";
                        case 4 -> "Assassino";
                        default -> "";
                    };
                    boolean encontrado = false;

                    for (Mercenario m : listaMercenarios) {
                        if (m.getClasse().equalsIgnoreCase(classeBuscada)) {
                            encontrado = true;
                            System.out.println(m.toString());
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Não há nenhum mercenário cadastrado na classe buscada.");
                    }
                }

                case 7 -> {
                    System.out.println("Saindo...");
                    saida = true;
                }
            }

        } while (!saida);
    }
}
