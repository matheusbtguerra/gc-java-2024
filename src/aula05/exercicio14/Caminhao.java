package aula05.exercicio14;

public class Caminhao implements Veiculo{
    String marca, modelo;
    int ano, maximoDeToneladas;

    public Caminhao(String marca, String modelo, int ano, int maximoDeToneladas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.maximoDeToneladas = maximoDeToneladas;
    }

    @Override
    public String coletarDetalhes() {
        return "\n------Informações do Veículo------" +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAno: " + ano +
                "\nMáximo de Toneladas: " + maximoDeToneladas;
    }
}