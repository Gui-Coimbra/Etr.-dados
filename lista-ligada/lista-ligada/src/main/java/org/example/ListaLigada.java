package org.example;

public class ListaLigada {


    private Node head;


    public ListaLigada() {
        head = new Node(0);


    public void insereNode(int valor) {
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }
    public void exibe()
    {
        Node atual = head.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }
    public Node buscaNode(int valor) {
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == valor) {
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }
    public Boolean removeNode(int valor) {
        Node ant = head;
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == valor) {
                ant.setNext(atual.getNext());
                return true;
            }
            ant = atual;
            atual = atual.getNext();
        }
        return false;
    }

    public int getTamanho() {
        Node atual = head.getNext();
        int tam = 0;
        while (atual != null) {
            tam++;
            atual = atual.getNext();
        }
        return tam;
    }
    public void inserirAposPrimeiroImpar(int valor){
        Node novo = new Node(valor);
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() % 2 != 0) {
                novo.setNext(atual.getNext());
                atual.setNext(novo);
                return;
            }
            atual = atual.getNext();
        }
    }


    public int getElemento(int indice) {
        Node atual = head.getNext();
        int i = 0;
        while (atual != null) {
            if (i == indice) {
                return atual.getInfo();
            }
            i++;
            atual = atual.getNext();
        }
        return -1;
    }
    public boolean removeOcorrencias(int valor) {
        Node ant = head;
        Node atual = head.getNext();
        boolean removeu = false;
        while (atual != null) {
            if (atual.getInfo() == valor) {
                ant.setNext(atual.getNext());
                removeu = true;
            } else {
                ant = atual;
            }
            atual = atual.getNext();
        }
        return removeu;
    }

    public void arrayToList(int[] vetor) {

        if (head.getNext() != null) {
            System.out.println("Operação inválida");
            return;
        } else {
            for (int i = 0; i < vetor.length; i++) {
                insereNode(vetor[i]);
            }
            System.out.println();

        }

    }

}
