package org.example;

public class ListaEstatica {
    private int[] vetor;
    private int numElem;

    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.numElem = 0;
    }

    public void adiciona(int numero){
        System.out.println("-".repeat(30));
        if(this.vetor.length == this.numElem){
            System.out.println("Lista cheia");
        }else{
            this.vetor[numElem++] = numero;
            System.out.println("Numero " + numero + " adicionado");
        }
        System.out.println("-".repeat(30));
    }

    public void exibe(){
        System.out.println("-".repeat(30));
        for(int i = 0; i < numElem; i++){
            System.out.println(vetor[i]);
        }
        System.out.println("-".repeat(30));
    }

    public int busca(int num){
        for(int i = 0; i < this.numElem; i++){
            if(vetor[i] == num){
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice){
        if(indice < numElem){
            for(int i = indice; i < numElem - 1; i++){
                    vetor[i] = vetor[i + 1];
            }
            numElem--;
            return true;
        }
        return false;
    }

    public boolean  removeElemento(int elemento){
        for(int i = 0; i < numElem; i++){
            if(vetor[i] == elemento){

            }
        }
    }
}