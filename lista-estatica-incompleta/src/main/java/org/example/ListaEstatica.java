package org.example;

import java.util.Arrays;

public class ListaEstatica {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private int[] vetor;


    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem

    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }


    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();

    public void adiciona(int elemento){
        if(nroElem == vetor.length){
            throw new IllegalStateException("Lista cheira");
        }else{
            this.vetor[nroElem++] = elemento;
        }
    }


    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou

    public int busca(int num){
        for(int i = 0; i < this.nroElem; i++){
            if(vetor[i] == num){
                return i;
            }
        }
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true

    public boolean removePeloIndice(int indice){
        if(indice >= 0 && indice < nroElem){
            for(int i = indice; i < nroElem - 1; i++){
                vetor[i] = vetor[i + 1];
            }
            nroElem--;
            return true;
        }
        return false;
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento

    public boolean removeElemento(int elemento){
        int indice = busca(elemento);
        if(indice < 0){
            return false;
        }
            removePeloIndice(indice);
            return true;
    }

    // 08 Método exibe:
    // Exibe os elementos da lista

    public void exibe(){
        for(int i = 0; i < nroElem; i++){
            System.out.println(vetor[i]);
        }
    }


    //Métodos getVetor e getNroElem
    //São usados nos testes
    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }
}
