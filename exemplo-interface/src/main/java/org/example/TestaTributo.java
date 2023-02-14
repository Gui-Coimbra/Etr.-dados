package org.example;

public class TestaTributo {

    public static void main(String[] args) {

        Alimento alimento = new Alimento(1, "Coxinha", 5.0, 10);
        Perfume perfume = new Perfume(2, "Malbec", 200.0, "Amadeirado");
        Servico servico = new Servico("Desenvolvedor", 200.0);
        Tributo tributo = new Tributo();
        tributo.adicionaTributavel(alimento);
        tributo.adicionaTributavel(servico);
        tributo.adicionaTributavel(perfume);

        tributo.exibeTodos();
        System.out.printf("\nTotal dos impostos: R$ %.2f\n", tributo.calculaTotalTributo());

    }
}
