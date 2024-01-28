import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListaProduto {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Produto produto1 = new Produto(1, "Smartphone X", "Eletrônicos", 899.99, 30);
        Produto produto2 = new Produto(2, "Smart TV 4K", "Casa", 1299.99, 15);
        Produto produto3 = new Produto(3, "Fone de Ouvido Bluetooth", "Som", 79.99, 50);
        Produto produto4 = new Produto(4, "Câmera Digital Profissional", "Eletrônicos", 1499.99, 10);
        Produto produto5 = new Produto(5, "Notebook UltraSlim", "PC", 1599.99, 20);
        Produto produto6 = new Produto(6, "Console de Videogame", "Casa", 399.99, 25);
        Produto produto7 = new Produto(7, "Caixa de Som Bluetooth", "Som", 59.99, 40);
        Produto produto8 = new Produto(8, "Monitor Gamer", "PC", 499.99, 18);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);
        produtos.add(produto7);
        produtos.add(produto8);

//        (a) Exiba os valores dos produtos da lista.
        System.out.println("\nLista dos produtos:");
        produtos.stream().forEach(System.out::println);

//        (b) Exiba somente os nomes dos produtos, em caixa alta (tudo maiúsculo), ordenados


//        (c) Crie um predicate para filtrar os preços entre um intervalo de valores. Exiba os
//        produtos que atendem esse filtro, ordenados.
        Predicate<Produto> quatroASeisMil =
                e -> (e.getPreco() >= 500 && e.getPreco() <= 1200);

//        (d) Exiba o primeiro produto que atende a esse filtro (predicate criado no item c).
        System.out.printf("\nPrimeiro produto com preço no intervalo de 500 a 1200:\n%s\n",
                produtos.stream()
                        .filter(quatroASeisMil)
                        .findFirst()
                        .get());

//        (e) Crie uma Function que retorna para cada produto o seu nome e uma outra Function
//        que retorna para cada produto a sua categoria. Crie um Comparator que compara
//        primeiro a categoria e depois o nome do produto. Exiba a lista dos produtos
//        ordenados por esse comparator.
        Function<Produto, String> nome = Produto::getNome;
        Function<Produto, String> categoria = Produto::getCategoria;

        Comparator<Produto> nomeCategoria =
                Comparator.comparing(categoria).thenComparing(nome);

        System.out.println("\nProdutos em ordem pela categoria, depois pelo nome:");
        produtos.stream()
                .sorted(nomeCategoria)
                .forEach(System.out::println);

//        (f) Exiba as categorias distintas da lista, em ordem alfabética
        System.out.println("\nCategorias distintas da lista de produtos");
        produtos.stream()
                .map(categoria)
                .distinct()
                .sorted()
                .forEach(System.out::println);

//        (g) Exiba a soma dos preços dos produtos usando .sum()
        System.out.printf("\nSoma dos preços dos produtos: %.2f\n",
                produtos.stream()
                        .mapToDouble(Produto::getPreco)
                        .sum());

//        (h) Exiba a soma dos preços dos produtos usando reduce
        System.out.printf("\nSoma dos preços dos produtos usando reduce: %.2f\n",
                produtos.stream()
                        .mapToDouble(Produto::getPreco)
                        .reduce(0, (subtotal, y) -> subtotal + y));

//        (i) Exiba a média dos preços dos produtos
        System.out.printf("\nMedia dos preços dos produtos: %.2f\n",
                produtos.stream()
                        .mapToDouble(Produto::getPreco)
                        .average()
                        .getAsDouble());

//        (j) Exiba a soma das quantidades de estoque usando .sum()
        System.out.printf("\nSoma das quantidades de estoque dos produtos: %.2f\n",
                produtos.stream()
                        .mapToDouble(Produto::getQtdEstoque)
                        .sum());

//        (k) Exiba os produtos agrupados pela categoria
        Map<String,List<Produto>> agrupadoPorCategoria =
                produtos.stream()
                        .collect(Collectors.groupingBy(Produto :: getCategoria));

        System.out.println("\nprodutos agrupados pela categoria:");
        agrupadoPorCategoria.forEach(
                (cat, produtosPorCategoria) ->
                {
                    System.out.println(cat);
                    produtosPorCategoria.forEach(
                            produto -> System.out.println("\t" + produto));
                }
        );

//        (l) Exiba a quantidade de produtos agrupados pela categoria
        Map <String, Long> qtdProdPorCat =
                produtos.stream()
                        .collect(Collectors.groupingBy(Produto::getCategoria,
                                Collectors.counting()));
        System.out.println("\nQuantidade de produtos por categoria:");
        qtdProdPorCat.forEach(
                (cat, quantidade) ->
                        System.out.println(cat + ": " + quantidade + " produtos"));

// (m) Desafio: exiba a soma dos preços dos produtos agrupados pela categoria
        Map<String, Double> somaPrecosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)));

        System.out.println("\nSoma dos preços dos produtos agrupados pela categoria:");
        somaPrecosPorCategoria.forEach((cat, somaPrecos) ->
                System.out.println(cat + ": " + somaPrecos));

// (n) Desafio: exiba a média dos preços dos produtos agrupados pela categoria
        Map<String, Double> mediaPrecosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)));

        System.out.println("\nMédia dos preços dos produtos agrupados pela categoria:");
        mediaPrecosPorCategoria.forEach((cat, mediaPrecos) ->
                System.out.println(cat + ": " + mediaPrecos));
    }
}