import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int[] valores = {5, 1, -20, 56, -49, 60, 34, -9};

//        (a) Exiba os dados do vetor
        System.out.println("Valores do vetor:");
        IntStream.of(valores)
                .forEach(valor -> System.out.printf("%d ", valor));

//        (b) Exiba a média dos valores do vetor
        System.out.printf("\nMédia: %.2f\n",IntStream.of(valores).average().getAsDouble());

//        (c) Exiba a soma dos valores do vetor, usando reduce
        System.out.printf("\nSoma dos valores do vetor, usando reduce: %d\n",
                IntStream.of(valores).reduce(0, (subtotal, y ) -> subtotal + y));

//        (d) Exiba a soma das metades dos valores do vetor, usando reduce


//        (e) Exiba a multiplicação dos quadrados dos valores do vetor, usando reduce
        System.out.printf("\nMultiplicação dos quadrados dos valores do vetor, " +
                        "usando reduce: %d\n",
                IntStream.of(valores).reduce(1, (subtotal, y ) -> subtotal + y * y));

//        (f) Exiba os valores múltiplos de 3, ordenados
        System.out.println("\nValores múltiplos de 3, ordenados:");
        IntStream.of(valores)
                .filter(valor -> valor % 3 == 0)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));

//        (g) Exiba os valores negativos, multiplicados por 5, ordenados
        System.out.println("\nValores negativos multiplicados por 5, ordenados:");
        IntStream.of(valores)
                .filter(valor -> valor < 0)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor * 5));
    }
}
