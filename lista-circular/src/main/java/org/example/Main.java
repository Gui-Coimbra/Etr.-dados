package org.example;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.insereNode("A");
        lista.insereNode("B");
        lista.insereNode("C");
        lista.insereNode("D");
        lista.insereNode("E");

        System.out.println(lista.getTamanho());
        lista.exibe();

        lista.josephus("A", 3);
    }
}