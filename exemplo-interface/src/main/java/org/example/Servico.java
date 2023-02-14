package org.example;

public class Servico implements Tributavel{

    private String descricao;
    private double preco;

    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public Double getValorTributo() {

        return preco*0.12;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descicao='" + descricao + '\'' +
                ", preco=" + preco +
                ", tributo=" + getValorTributo() +
                '}';
    }
}
