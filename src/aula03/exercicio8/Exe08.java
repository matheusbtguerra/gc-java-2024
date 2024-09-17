package aula03.exercicio8;

public class Exe08 {
    public static void main(String[] args) {
        Moto moto = new Moto(2005, "Factor","Yamaha");
        Carro carro = new Carro(2020, "Ka", "Ford");

        System.out.println(moto.calcularCustoViagem(200));
        System.out.println(carro.calcularCustoViagem(200));
    }
}
