package aula05.exercicio13;

import java.time.LocalDate;

public class Compra {
    private String nome;
    private LocalDate data;

    public Compra(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }
}