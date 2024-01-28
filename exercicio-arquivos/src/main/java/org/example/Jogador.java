package org.example;

public class Jogador {

    private static int contadorId = 0;
    private int id;
    private String nome;
    private int idade;
    private double salario;
    private String nacionalidade;
    private String time;
    private boolean isMelhorDoMundo;

    public Jogador(
            String nome,
            int idade,
            double salario,
            String nacionalidade,
            String time,
            boolean isMelhorDoMundo
    ) {
        this.id = ++contadorId;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.nacionalidade = nacionalidade;
        this.time = time;
        this.isMelhorDoMundo = isMelhorDoMundo;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", salario=" + salario +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", time='" + time + '\'' +
                ", isMelhorDoMundo=" + isMelhorDoMundo +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isMelhorDoMundo() {
        return isMelhorDoMundo;
    }

    public void setMelhorDoMundo(boolean melhorDoMundo) {
        isMelhorDoMundo = melhorDoMundo;
    }
}