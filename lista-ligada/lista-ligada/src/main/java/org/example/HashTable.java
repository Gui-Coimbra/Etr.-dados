package org.example;

public class HashTable {
    ListaLigada tab[];

    public HashTable(int n) {
        tab = new ListaLigada[n];
        for (int i = 0; i < n; i++) {
            tab[i] = new ListaLigada();
        }
    }

    public void insere(int valor) {
        int pos = valor % tab.length;
        tab[pos].insereNode(valor);
    }
    public void funcaoHash(int valor){
        int pos = valor % tab.length;
        System.out.println("Posição: " + pos);
    }

    public boolean busca(int valor) {
        int pos = valor % tab.length;
        return tab[pos].buscaNode(valor) != null;
    }
    public boolean remove(int valor) {
        int pos = valor % tab.length;
        return tab[pos].removeNode(valor);
    }
    public void exibe() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Entrada " + i + ": ");
            if (tab[i].getTamanho() == 0) {
                System.out.println("Lista vazia");
            } else {
                tab[i].exibe();
            }
        }
    }


}


