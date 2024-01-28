package org.example;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.insereNodeFinal(1);
        lista.insereNodeFinal(0);
        lista.insereNodeFinal(1);

        System.out.print("Lista do início para o final: ");
        lista.exibeDoInicio();

        System.out.print("Lista do final para o início: ");
        lista.exibeDoFinal();
        
        int valorRemovido = 0;
        if (lista.removeNode(0)) {
            valorRemovido = 0;
        }

        System.out.print("Lista após a remoção: ");
        lista.exibeDoInicio();

        int numeroDecimal = 10;
        while (numeroDecimal > 0) {
            int resto = numeroDecimal % 2;
            lista.insereNodeInicio(resto);
            numeroDecimal = numeroDecimal / 2;
        }

        System.out.print("Número binário: ");
        lista.exibeDoInicio();
    }
}