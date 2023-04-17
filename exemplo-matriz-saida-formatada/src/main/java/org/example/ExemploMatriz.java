package org.example;

import java.util.Scanner;

public class ExemploMatriz {

    public static void exibeMatriz(int[][] matriz) {
        for (int linha=0; linha < matriz.length; linha++ ) {
            for (int coluna=0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    public static void exibeMatrizTransposta(int[][] matriz) {
        for (int coluna=0; coluna < matriz[0].length; coluna++ ) {
            for (int linha=0; linha < matriz.length; linha++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Criação de um objeto Scanner
        Scanner leitor = new Scanner(System.in);

        // Declaração de um vetor
        int[] vetor = new int[5];

        // Declaração de uma matriz 3 x 4
        int[][] matriz = new int[3][4];

        // Declaração de uma matriz já inicializada com valores
        int[][] matriz2 = { {1,2}, {3,4}, {5,6}, {7,8} };

        // Declaração de uma matriz irregular, com quantidade de colunas
        // diferentes em cada linha
        int[][] matrizLoka = { {1}, {2, 3, 4, 5}, {6, 7}, {8, 9, 10} };

        // Criação de uma matriz irregular, sem os inicializadores
        int[][] matrizLoka2 = new int[4][];
        matrizLoka2[0] = new int[5];
        matrizLoka2[1] = new int[1];
        matrizLoka2[2] = new int[7];
        matrizLoka2[3] = new int[4];

        // Solicita que o usuário digite os valores para
        // preencher a matriz
        for (int linha=0; linha < matriz.length; linha++ ) {
            for (int coluna=0; coluna < matriz[linha].length; coluna++) {
                System.out.println("Digite o valor de matriz["+linha+"]["+
                                   coluna+"]");
                matriz[linha][coluna] = leitor.nextInt();
            }
        }

        // Exibe a matriz no formato de matriz
        System.out.println("\nExibição da matriz");
        exibeMatriz(matriz);

        // Exibe a matriz2 no formato de matriz
        System.out.println("\nExibição da matriz2");
        exibeMatriz(matriz2);

        // Exibe a matrizLoka no formato de matriz
        System.out.println("\nExibição da matrizLoka");
        exibeMatriz(matrizLoka);

        // Exibe a matriz transposta da matriz
        System.out.println("\nExibição da matriz transposta da matriz");
        exibeMatrizTransposta(matriz);

        // Exibe a matriz transposta da matriz2
        System.out.println("\nExibição da matriz transposta da matriz2");
        exibeMatrizTransposta(matriz2);

    }

}
