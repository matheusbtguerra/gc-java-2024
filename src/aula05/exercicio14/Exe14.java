package aula05.exercicio14;

import java.util.ArrayList;
import java.util.List;

public class Exe14 {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Ford", "Ká", 2020, 4);
        Carro carro2 = new Carro("Ford", "Fiesta", 2014, 4);
        Moto moto1 = new Moto("Triumph", "Daytona", 2014, 675);
        Moto moto2 = new Moto("Triumph", "Tiger", 2019, 660);
        Caminhao caminhao1 = new Caminhao("Volvo", "FH540",2016, 5);
        Caminhao caminhao2 = new Caminhao("Volvo", "VM220",2013, 3);

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(carro1);
        veiculos.add(carro2);
        veiculos.add(moto1);
        veiculos.add(moto2);
        veiculos.add(caminhao1);
        veiculos.add(caminhao2);

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.coletarDetalhes());
        }


    }
}