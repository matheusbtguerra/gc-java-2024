package aula05.exercicio14;

public class Moto implements Veiculo{
    String marca, modelo;
    int ano, cilindradas;

    public Moto(String marca, String modelo, int ano, int cilindradas) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cilindradas = cilindradas;
    }

    @Override
    public String coletarDetalhes() {
        return "\n------Informações do Veículo------" +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nAno: " + ano +
                "\nCilindradas: " + cilindradas;
    }
}