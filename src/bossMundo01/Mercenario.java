package bossMundo01;

public class Mercenario {
    String nome, classe;
    int idade, salarioBase, avaliacaoDesempenho;

    public Mercenario(String nome, String classe, int idade, int salarioBase, int avaliacaoDesempenho) {
        this.nome = nome;
        this.classe = classe;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.avaliacaoDesempenho = avaliacaoDesempenho;
    }

    @Override
    public String toString() {
        return "\n-----------------Mercenário-----------------\n" +
                "Nome do Mercenário: " + nome + "\n" +
                "Classe: " + classe + "\n" +
                "Idade: " + idade + "\n" +
                "SalarioBase: " + salarioBase + "\n" +
                "AvaliacaoDesempenho: " + avaliacaoDesempenho + "\n" +
                "---------------------------------------------";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getAvaliacaoDesempenho() {
        return avaliacaoDesempenho;
    }

    public void setAvaliacaoDesempenho(int avaliacaoDesempenho) {
        this.avaliacaoDesempenho = avaliacaoDesempenho;
    }
}
