package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ProcessandoEmpregados {

    public static void main(String[] args) {
        Empregado[] empregados = {
                new Empregado("Jorge", "Silva", 5000.0, "TI"),
                new Empregado("Aldo", "Sousa", 7600.0, "TI"),
                new Empregado("Marcos", "Teixeira", 3000.0, "Vendas"),
                new Empregado("Pedro", "Nunes", 4500.0, "Marketing"),
                new Empregado("Luis", "Santos", 6000.0, "TI"),
                new Empregado("Jorge", "Rocha", 3500.0, "Vendas"),
                new Empregado("Nelson", "Alves", 4900.0, "Marketing")
        };

        List<Empregado> lista = Arrays.asList(empregados);

        // exibe todos os empregados
        System.out.println("\nLista dos empregados:");
        lista.stream().forEach(System.out::println);

        // Predicate que retorna true para salÃ¡rios no intervalo de 4000 a 6000
        Predicate<Empregado> quatroASeisMil =
                e -> (e.getSalario() >= 4000 && e.getSalario() <= 6000);

        // Exibe empregados com salarios no intervalo de 4000 a 6000, em ordem crescente por salario
        System.out.printf("\nEmpregados que ganham de 4000 a 6000 por mes, ordenados pelo salario:\n");
        lista.stream()
                .filter(quatroASeisMil)
                .sorted(Comparator.comparing(Empregado::getSalario))
                .forEach(System.out::println);

        // Exibe o primeiro empregado com salario no intervalo de 4000 a 6000
        System.out.printf("\nPrimeiro empregado que ganha salario no intervalo de 4000 a 6000:\n%s\n",
                lista.stream()
                        .filter(quatroASeisMil)
                        .findFirst()
                        .get());

    }
}
