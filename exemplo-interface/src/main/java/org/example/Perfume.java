package org.example;

public class Perfume extends Produto{

    private String fragrancia;

    public Perfume(int codigo, String descricao, double preco, String fragrancia) {
        super(codigo, descricao, preco);
        this.fragrancia = fragrancia;
    }

    @Override
    public Double getValorTributo() {
        return getPreco()*0.27;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "fragrancia='" + fragrancia + '\'' +
                "} " + super.toString();
    }
}
