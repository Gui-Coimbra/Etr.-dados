package org.example;
import org.example.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable tabela = new HashTable(5); // cria uma tabela de hash com 5 entradas

        tabela.insere(5);
        tabela.insere(10);
        tabela.insere(15);
        tabela.insere(20);

        // Exibe os valores nas entradas da tabela
        tabela.exibe();

        // Testa a busca
        System.out.println("Busca 10: " + tabela.busca(10)); // Deve retornar true
        System.out.println("Busca 25: " + tabela.busca(25)); // Deve retornar false

        // Testa a remoção
        System.out.println("Remove 15: " + tabela.remove(15)); // Deve retornar true
        System.out.println("Remove 25: " + tabela.remove(25)); // Deve retornar false

        // Exibe os valores nas entradas da tabela após a remoção
        tabela.exibe();
    }
}
