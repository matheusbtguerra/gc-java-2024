package aula03.exercicio8;

public class Moto extends Veiculo{
    public Moto(int ano, String modelo, String marca) {
        super(ano, modelo, marca);
    }

    @Override
    public double calcularCustoViagem(double distancia) {
        double custoFixo = 0.15, custoViagem;
        custoViagem = custoFixo * distancia;
        return custoViagem;
    }
}
