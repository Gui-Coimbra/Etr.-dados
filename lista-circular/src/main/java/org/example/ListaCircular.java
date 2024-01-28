package org.example;

public class ListaCircular {

    private Node head;

    public ListaCircular() {
        this.head = new Node(null);
        head.setNext(head);
    }

    public void insereNode(String valor) {
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    public void exibe() {
        Node atual = head.getNext();
        while (atual != head) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }

    public boolean removeNode(String valor) {
        Node ant = head;
        Node atual = head.getNext();
        while (atual != head) {
            if (atual.getInfo().equals(valor)) {
                ant.setNext(atual.getNext());
                return true;
            } else {
                ant = atual;
                atual = atual.getNext();
            }
        }
        return false;
    }

    public int getTamanho() {
        Node atual = head.getNext();
        int tamanho = 0;
        while (atual != head) {
            tamanho++;
            atual = atual.getNext();
        }
        return tamanho;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void josephus(String soldadoInicial, int n) {
        Node atual = head.getNext();
        Node soldadoInicialNode = null;

        while (atual != head) {
            if (atual.getInfo().equals(soldadoInicial)) {
                soldadoInicialNode = atual;
                break;
            }
            atual = atual.getNext();
        }

        if (soldadoInicialNode != null) {
            atual = soldadoInicialNode;
            while (getTamanho() > 1) {
                for (int i = 1; i < n; i++) {
                    atual = atual.getNext();
                }
                Node eliminado = atual.getNext();
                System.out.println("Soldado eliminado: " + eliminado.getInfo());
                atual.setNext(eliminado.getNext());
            }
            System.out.println("Soldado que escapará: " + atual.getInfo());
        }
    }
}