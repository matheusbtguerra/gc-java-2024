package aula03.exercicio8;

public abstract class Veiculo {
    String marca, modelo;
    int ano;

    public Veiculo(int ano, String modelo, String marca) {
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
    }

    public abstract double calcularCustoViagem(double distancia);

}
