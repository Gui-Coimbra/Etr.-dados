package org.example;

public class Main {

    public static void main(String[] args) {

        ListaEstatica lista = new ListaEstatica(5);

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);
        lista.adiciona(5);
        lista.adiciona(6);

        lista.exibe();

        System.out.println(lista.busca(3));
        System.out.println(lista.busca(6));

        System.out.println(lista.removePeloIndice(2));

        lista.exibe();

        System.out.println(lista.contaOcorrencias(4));
        lista.adicionaNoInicio(10);
        lista.substituirPorElemento(3, 15);
        lista.exibe();
    }
}
