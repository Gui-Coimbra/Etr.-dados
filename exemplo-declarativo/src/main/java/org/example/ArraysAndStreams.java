package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

    public static void main(String[] args) {
        Integer[] valores = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};
        String[] cores = {"Red", "orange", "Yellow", "green",
                "Blue", "indigo", "Violet"};

        System.out.printf("Valores originais: %s\n",
                Arrays.asList(valores));

        // Exibicao ordenada dos valores
        System.out.printf("Valores ordenados: %s\n",
                Arrays.stream(valores)
                        .sorted()
                        .collect(Collectors.toList()));

        // Exibicao dos valores maiores que 4
        List<Integer> maiorQue4 =
                Arrays.stream(valores)
                        .filter(valor -> valor > 4)
                        .collect(Collectors.toList());
        System.out.printf("Valores maiores que 4: %s\n", maiorQue4);

        // Exibicao ordenada dos valores maiores que 4
        System.out.printf("Valores maiores que 4, ordenados: %s\n",
                maiorQue4.stream()
                        .sorted()
                        .collect(Collectors.toList()));

        // Exibe vetor de cores
        System.out.printf("\nValores originais: %s\n",
                Arrays.asList(cores));

        // Exibe vetor de cores em UPPERCASE
        System.out.printf("Cores em uppercase: %s\n",
                Arrays.stream(cores)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // Exibe as cores cuja primeira letra é maior que "n" em ordem crescente
        System.out.printf("Cores com primeira letra maior que n, em ordem crescente: %s\n",
                Arrays.stream(cores)
                        .filter(s -> s.compareToIgnoreCase("n") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // Exibe as cores cuja primeira letra é maior que "n" em ordem decrescente
        System.out.printf("Cores com primeira letra maior que n, em ordem decrescente: %s\n",
                Arrays.stream(cores)
                        .filter(s -> s.compareToIgnoreCase("n") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

    }
}
