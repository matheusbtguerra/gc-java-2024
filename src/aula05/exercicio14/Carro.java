package aula05.exercicio14;

public class Carro implements Veiculo{
    String marca, modelo;
    int ano, numeroDePortas;

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public String coletarDetalhes() {
        return "\n------Informações do Veículo------" +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAno: " + ano +
                "\nNúmero de Portas: " + numeroDePortas;
    }
}