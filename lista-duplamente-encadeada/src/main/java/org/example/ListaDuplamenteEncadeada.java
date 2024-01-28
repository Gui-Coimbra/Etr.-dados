package org.example;

public class ListaDuplamenteEncadeada {

    private Node head;
    private Node tail;

    public ListaDuplamenteEncadeada() {
        this.head = new Node(0);
        this.tail = new Node(0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void insereNodeInicio(int valor){
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        novo.setPrev(head);
        head.getNext().setPrev(novo);
        head.setNext(novo);
    }

    public void insereNodeFinal(int valor) {
        Node novo = new Node(valor);
        novo.setPrev(tail.getPrev());
        novo.setNext(tail);
        tail.getPrev().setNext(novo);
        tail.setPrev(novo);
    }

    public void exibeDoInicio() {
        Node atual = head.getNext();
        while (atual != tail) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getNext();
        }
        System.out.println();
    }

    public void exibeDoFinal() {
        Node atual = tail.getPrev();
        while (atual != head) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getPrev();
        }
        System.out.println();
    }

    public boolean removeNode(int valor) {
        Node atual = head.getNext();
        while (atual != tail) {
            if (atual.getInfo() == valor) {
                atual.getPrev().setNext(atual.getNext());
                atual.getNext().setPrev(atual.getPrev());
                return true;
            }
            atual = atual.getNext();
        }
        return false;
    }

    public int getTamanho() {
        int tamanho = 0;
        Node atual = head.getNext();
        while (atual != tail) {
            tamanho++;
            atual = atual.getNext();
        }
        return tamanho;
    }

    public int removeNodeInicio() {
        if (head.getNext() == tail) {
            return -1;
        }
        Node removedNode = head.getNext();
        head.setNext(removedNode.getNext());
        removedNode.getNext().setPrev(head);
        return removedNode.getInfo();
    }

    public int removeNodeFinal() {
        if (tail.getPrev() == head) {
            return -1; // Lista vazia
        }
        Node removedNode = tail.getPrev();
        tail.setPrev(removedNode.getPrev());
        removedNode.getPrev().setNext(tail);
        return removedNode.getInfo();
    }
}
