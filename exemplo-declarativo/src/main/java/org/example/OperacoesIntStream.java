package org.example;

import java.util.stream.IntStream;

public class OperacoesIntStream {
    public static void main(String[] args) {

        int[] valores = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        // Exibe os valores do vetor
        System.out.println("Valores do vetor:");
        IntStream.of(valores)
                 .forEach(valor -> System.out.printf("%d ", valor));

        // count, min, max, sum e average do vetor
        System.out.printf("\nContagem: %d\n",IntStream.of(valores).count());
        System.out.printf("Mínimo: %d\n",IntStream.of(valores).min().getAsInt());
        System.out.printf("Máximo: %d\n",IntStream.of(valores).max().getAsInt());
        System.out.printf("Soma: %d\n",IntStream.of(valores).sum());
        System.out.printf("Média: %.2f\n",IntStream.of(valores).average().getAsDouble());

        System.out.println(IntStream.of(valores).summaryStatistics());

        // Soma dos valores do vetor usando reduce
        System.out.printf("\nSoma dos valores do vetor, usando reduce: %d\n",
                IntStream.of(valores).reduce(0, (subtotal, y ) -> subtotal + y));

        // Multiplicação dos valores do vetor usando reduce
        System.out.printf("\nMultiplicação dos valores do vetor, usando reduce: %d\n",
                IntStream.of(valores).reduce(1, (subtotal, y ) -> subtotal * y));

        // Soma dos quadrados dos valores do vetor usando reduce
        System.out.printf("\nSoma dos quadrados dos valores do vetor, usando reduce: %d\n",
                IntStream.of(valores).reduce(0, (subtotal, y ) -> subtotal + y * y));

        // Exibição dos valores impares do vetor, ordenados
        System.out.println("\nValores ímpares do vetor, ordenados:");
        IntStream.of(valores)
                 .filter(valor -> valor % 2 != 0)
                 .sorted()
                 .forEach(valor -> System.out.printf("%d ", valor));

        // Exibição dos valores pares do vetor, multiplicados por 10, ordenados
        System.out.println("\nValores pares do vetor, multiplicados por 10, ordenados:");
        IntStream.of(valores)
                .filter(valor -> valor % 2 == 0)
                .map(valor -> valor * 10)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));

        // Soma o intervalo dos numeros de 1 a 10 (exclusivo, não considera o final)
        // ou seja, intervalo de 1 a 9
        System.out.printf("\nSoma dos inteiros de 1 a 9: %d\n",
                IntStream.range(1, 10).sum());

        // Soma o intervalo dos numeros de 1 a 10 (inclusive o 10)
        System.out.printf("\nSoma dos inteiros de 1 a 10: %d\n",
                IntStream.rangeClosed(1, 10).sum());

    }
}
