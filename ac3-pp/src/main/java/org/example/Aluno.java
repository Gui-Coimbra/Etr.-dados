package org.example;

public class Aluno {

    // Atributos
    private int ra;
    private String nome;
    private String curso;
    private Double media;
    private int pontuacao;

    // Construtor

    public Aluno(int ra, String nome, String curso, Double media, int pontuacao) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
        this.media = media;
        this.pontuacao = pontuacao;
    }


    // toString()

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", media=" + media +
                ", pontuacao=" + pontuacao +
                '}';
    }

    // Getters e Setters

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
