package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Cria uma lista de alunos
        List<Aluno> lista = new ArrayList();
        lista.add(new Aluno(30000, "Claudio Silva", "CCO", 7.5, 700));
        lista.add(new Aluno(30001, "Ana Sousa", "ADS", 9.0, 900));
        lista.add(new Aluno(30002, "Rodolfo Miranda", "CCO", 6.5, 500));
        lista.add(new Aluno(30003, "Horacio Bispo", "ADS", 8.0, 400));
        lista.add(new Aluno(30004, "Fabiola Chagas", "CCO", 8.5, 100));
        lista.add(new Aluno(30005, "Beatriz Machado", "ADS", 6.0, 200));
        lista.add(new Aluno(30006, "Clara Teixeira", "CCO", 7.0, 300));

        // 1- Crie uma arvore binaria de busca, onde o Node armazene objeto Aluno
        //    O criterio da busca na arvore eh a media do aluno
        ArvBinBusca arvore = new ArvBinBusca();

        // 2- Percorra a lista criada acima, inserindo os alunos da lista na arvore binaria
        for(Aluno aluno : lista){
            arvore.insere(aluno);
        }

        // 3- Exiba a arvore em pre-ordem
        System.out.println("-".repeat(30));
        System.out.println("Arvore em pre-ordem");
        arvore.preOrdem(arvore.getRaiz());
        System.out.println();

        // 4- Exiba a arvore em em-ordem
        System.out.println("-".repeat(30));
        System.out.println("Arvore em em-ordem");
        arvore.emOrdem(arvore.getRaiz());
        System.out.println();

        // 5- Exiba a arvore em pos-ordem
        System.out.println("-".repeat(30));
        System.out.println("Arvore em pos-ordem");
        arvore.posOrdem(arvore.getRaiz());
        System.out.println();

        // 6- Usando paradigma funcional/declarativo, exiba a lista acima
        System.out.println("-".repeat(30));
        System.out.println("Lista de alunos");
        System.out.println("-".repeat(30));
        lista.stream().forEach(System.out::println);

        // 7- Usando paradigma funcional/declarativo, exiba a soma das pontuacoes somente dos alunos de CCO

        Predicate<Aluno> somenteCco =
                e -> (e.getCurso() == "CCO");

        System.out.printf("\nSoma das pontuações dos alunos de CCO: %.2f\n",
                lista.stream()
                        .filter(somenteCco)
                        .mapToDouble(Aluno::getPontuacao)
                        .sum());

        // 8- Usando paradigma funcional/declarativo, exiba a media das medias dos alunos de ADS
        Predicate<Aluno> somenteAds =
                e -> (e.getCurso() == "ADS");

        System.out.printf("\nMedia das medias dos alunos de ADS: %.2f\n",
                lista.stream()
                        .filter(somenteAds)
                        .mapToDouble(Aluno::getMedia)
                        .average()
                        .getAsDouble());

        // 9- Usando reduce, exiba a soma das pontuacoes de todos os alunos
        System.out.printf("\nSoma das pontuacoes dos alunos usando reduce: %.2f\n",
                lista.stream()
                        .mapToDouble(Aluno::getPontuacao)
                        .reduce(0, (subtotal, y) -> subtotal + y));

        // 10- Usando paradigma funcional/declarativo, exiba os alunos agrupados pelo curso
        System.out.println("\nAlunos agrupados por curso:");
        Map<String,List<Aluno>> agrupadoPorCurso =
                lista.stream()
                        .collect(Collectors.groupingBy(Aluno :: getCurso));

        agrupadoPorCurso.forEach(
                (curso, alunosPorCurso) ->
                {
                    System.out.println(curso);
                    alunosPorCurso.forEach(
                            aluno -> System.out.println("\t" + aluno));
                }
        );

        // 11- Usando paradigma funcional/declarativo, exiba os alunos em ordem alfabetica
        Function<Aluno, String> nome = Aluno::getNome;
        Comparator<Aluno> nomeCategoria =
                Comparator.comparing(nome).thenComparing(nome);

        System.out.println("\nAlunos em ordem alfabetica:");
        lista.stream()
                .sorted(nomeCategoria)
                .forEach(System.out::println);
    }
}