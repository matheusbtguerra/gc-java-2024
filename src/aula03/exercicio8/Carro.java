package aula03.exercicio8;

public class Carro extends Veiculo {
    public Carro(int ano, String modelo, String marca) {
        super(ano, modelo, marca);
    }

    @Override
    public double calcularCustoViagem(double distancia) {
        double custoFixo = 0.20, custoViagem;
        custoViagem = custoFixo * distancia;
        return custoViagem;
    }
}
