package aula04.exercicio10;

public class Carro extends Veiculo {
    int numeroDePortas;

    public Carro(int ano, String modelo, String marca, int numeroDePortas) {
        super(ano, modelo, marca);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public void informacoes() {
        System.out.println("\n---------Informações do Veículo---------");
        System.out.println("\nModelo: " + modelo + "\n Marca: " + marca + "\n Ano: " + ano + "\n Número de Portas: " + numeroDePortas);
    }
}
