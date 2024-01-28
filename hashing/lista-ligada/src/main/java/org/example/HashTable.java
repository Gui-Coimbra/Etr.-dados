package org.example;

public class HashTable {

    private ListaLigada[] tab;

    public HashTable(int tamanho) {
        tab = new ListaLigada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tab[i] = new ListaLigada();
        }
    }

    private int funcaoHash(int x) {
        return x % tab.length;
    }

    public void insere(int valor) {
        int indice = funcaoHash(valor);
        tab[indice].insereNode(valor);
    }

    public boolean busca(int valor) {
        int indice = funcaoHash(valor);
        Node encontrado = tab[indice].buscaNode(valor);
        return encontrado != null;
    }

    public boolean remove(int valor) {
        int indice = funcaoHash(valor);
        return tab[indice].removeNode(valor);
    }

    public void exibe() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Entrada " + i + ": ");
            tab[i].exibe();
        }
    }
}
