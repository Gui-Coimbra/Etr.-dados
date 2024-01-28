package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessandoEmpregados {

    public static void main(String[] args) {
        Empregado[] empregados = {
                new Empregado("Jorge", "Sousa", 5000.0, "TI"),
                new Empregado("Aldo", "Sousa", 7600.0, "TI"),
                new Empregado("Marcos", "Teixeira", 3000.0, "Vendas"),
                new Empregado("Pedro", "Nunes", 4500.0, "Marketing"),
                new Empregado("Luis", "Sousa", 6000.0, "TI"),
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

        // Declaracao de 2 Functions
        // cada uma delas recebe um empregado como argumento e retorna uma String
        // Empregado :: getPrimeiroNome é o mesmo que
        // Empregado e -> return e.getPrimeiroNome()
        Function<Empregado, String> peloPrimeiroNome = Empregado :: getPrimeiroNome;
        Function<Empregado, String> peloSobrenome = Empregado :: getSobrenome;

        Comparator<Empregado> sobrenomePrimeiroNome =
                Comparator.comparing(peloSobrenome).thenComparing(peloPrimeiroNome);

        System.out.println("\nEmpregados em ordem pelo sobrenome, depois pelo primeiro nome:");
        lista.stream()
             .sorted(sobrenomePrimeiroNome)
             .forEach(System.out::println);

        // Exibe os sobrenomes unicos (distintos) da lista
        // Exemplo de uso do map para mapear para um outro tipo
        System.out.println("\nSobrenomes distintos da lista de empregados");
        lista.stream()
                .map(peloSobrenome)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // Soma os salarios dos empregados
        System.out.printf("\nSoma dos salarios dos empregados: %.2f\n",
                lista.stream()
                        .mapToDouble(Empregado::getSalario)
                        .sum());

        // Soma os salarios dos empregados usando reduce
        System.out.printf("\nSoma dos salarios dos empregados usando reduce: %.2f\n",
                lista.stream()
                        .mapToDouble(Empregado::getSalario)
                        .reduce(0, (subtotal, y) -> subtotal + y));

        // Media dos salarios dos empregados
        System.out.printf("\nMedia dos salarios dos empregados: %.2f\n",
                lista.stream()
                        .mapToDouble(Empregado::getSalario)
                        .average()
                        .getAsDouble());

        // Exibe os empregados agrupados pelo departamento
        Map<String,List<Empregado>> agrupadoPorDepto =
                lista.stream()
                     .collect(Collectors.groupingBy(Empregado :: getDepartamento));

        System.out.println("\nEmpregados agrupados pelo departamento:");
        agrupadoPorDepto.forEach(
                (departamento, empregadosDoDepto) ->
                {
                    System.out.println(departamento);
                    empregadosDoDepto.forEach(
                            empregado -> System.out.println("\t" + empregado));
                }
        );

        // Exibe a quantidade de empregados de cada departamento

        Map <String, Long> qtdadeEmpregadosPorDepto =
            lista.stream()
                 .collect(Collectors.groupingBy(Empregado::getDepartamento,
                                                Collectors.counting()));
        System.out.println("\nQuantidade de empregados por departamento:");
        qtdadeEmpregadosPorDepto.forEach(
          (departamento, quantidade) ->
               System.out.println(departamento + ": " + quantidade + " empregados"));

    }
}
