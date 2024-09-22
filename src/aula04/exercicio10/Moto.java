package aula04.exercicio10;

public class Moto extends Veiculo {
    String tipoDeGuidao;

    public Moto(int ano, String modelo, String marca, String tipoDeGuidao) {
        super(ano, modelo, marca);
        this.tipoDeGuidao = tipoDeGuidao;
    }

    @Override
    public void informacoes() {
        System.out.println("\n---------Informações do Veículo---------");
        System.out.println("\nModelo: " + modelo + "\n Marca: " + marca + "\n Ano: " + ano + "\n Tipo de Guidão: " + tipoDeGuidao);
    }
}
