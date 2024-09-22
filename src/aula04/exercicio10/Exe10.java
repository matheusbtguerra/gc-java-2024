package aula04.exercicio10;

public class Exe10 {
    public static void main(String[] args) {
        Moto moto = new Moto(2005, "Factor","Yamaha", "Normal");
        Carro carro = new Carro(2020, "Ka", "Ford", 4);

        carro.informacoes();
        moto.informacoes();
    }
}
