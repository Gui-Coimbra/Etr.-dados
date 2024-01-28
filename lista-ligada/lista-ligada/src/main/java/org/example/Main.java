package org.example;

public class Main {
    public static void main(String[] args) {
        Node retornado;
        ListaLigada lista = new ListaLigada();
        ListaLigada lista2 = new ListaLigada();

        HashTable tabela = new HashTable(10);

        lista.insereNode(10);
        lista.insereNode(3);
        lista.insereNode(20);
        lista.insereNode(30);

        lista.exibe();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        lista.insereNode(40);
        lista.insereNode(50);


        lista.exibe();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        retornado = lista.buscaNode(40);
        if (retornado == null) {
            System.out.println("Valor 40 não foi encontrado");
        }
        else {
            System.out.println("Encontrado node com valor " + retornado.getInfo());
        }

        retornado = lista.buscaNode(77);
        if (retornado == null) {
            System.out.println("Valor 77 não foi encontrado");
        }
        else {
            System.out.println("Encontrado node com valor " + retornado.getInfo());
        }

        if (lista.removeNode(20)) {
            System.out.println("Valor 20 removido com sucesso");
        }
        else {
            System.out.println("Valor 20 não foi encontrado para remoção");
        }

        lista.exibe();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        if (lista.removeNode(100)) {
            System.out.println("Valor 100 removido com sucesso");
        }
        else {
            System.out.println("Valor 100 não foi encontrado para remoção");
        }
        System.out.println("Insere 100 após o primeiro ímpar");
        lista.inserirAposPrimeiroImpar(100);
        lista.exibe();
        System.out.println("Elemento pelo indice:");
        System.out.println(lista.getElemento(1));
        System.out.println("Remove ocorrências:");
        System.out.println(lista.removeOcorrencias(50));
        lista.exibe();
        System.out.println("Array to list:");
        int[] vetor = {30,50,60,10};
        lista2.arrayToList(vetor);
        lista2.exibe();

        System.out.println("Hash Table:");
        tabela.insere(45);
        tabela.insere(17);
        tabela.insere(18);
        tabela.insere(78);
        tabela.insere(98);
        tabela.insere(60);
        tabela.insere(70);
        tabela.insere(3);
        tabela.insere(13);
        tabela.insere(23);
        tabela.insere(33);
        tabela.exibe();
        System.out.println("Busca:");
        System.out.println(tabela.busca(45));
        System.out.println("Remove:");
        System.out.println(tabela.remove(45));
        tabela.exibe();
        System.out.println("Função Hash:");
        tabela.funcaoHash(17);

    }





}