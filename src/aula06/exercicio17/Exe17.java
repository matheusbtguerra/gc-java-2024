package aula06.exercicio17;

import java.util.HashSet;

public class Exe17 {
    public static void main(String[] args) {
        HashSet<Integer> listaInteiros = new HashSet<>();
        listaInteiros.add(1);
        listaInteiros.add(2);
        listaInteiros.add(2);
        listaInteiros.add(3);
        listaInteiros.add(4);
        listaInteiros.add(5);
        listaInteiros.add(3);

        System.out.println(listaInteiros);
    }
}
