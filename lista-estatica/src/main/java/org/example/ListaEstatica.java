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
        if(indice >= 0 && indice < numElem){
            for(int i = indice; i < numElem - 1; i++){
                    vetor[i] = vetor[i + 1];
            }
            numElem--;
            return true;
        }
        return false;
    }

    public boolean  removeElemento(int elemento){
        int indice = this.busca(elemento);
        if(indice < 0){
            return false;
        }else{
            while(indice < this.numElem - 1){
                this.vetor[indice] = this.vetor[indice + 1];
                indice++;
            }
            --this.numElem;
            return true;
        }
    }

    public boolean substituirPorElemento(int elemAntigo, int elemNovo) {
        for (int i = 0; i < this.vetor.length; ++i) {
            if (this.vetor[i] == elemAntigo) {
                this.vetor[i] = elemNovo;
                return true;
            }
        }
        System.out.println("valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int elemento) {
     int soma = 0;

     for(int i = 0; i < this.vetor.length; ++i) {
        if (this.vetor[i] == elemento) {
            soma++;
        }
     }

        return soma;
    }

    public boolean adicionaNoInicio(int elemento) {
        if (this.numElem == this.vetor.length) {
            System.out.println("Lista cheia");
            return false;
        } else {
            for(int i = this.numElem - 1; i >= 0; --i) {
                this.vetor[i + 1] = this.vetor[i];
            }

            this.vetor[0] = elemento;
             int[] vetorAux = this.vetor;
             int tamanhoAux = vetorAux.length;

             for(int k = 0; k < tamanhoAux; ++k) {
                int valor = vetorAux[k];
                System.out.println(valor);
             }

            return true;
        }
 }

}