public class TestaFilaLigada {
    public static void main(String[] args) {
        FilaLigada<Integer> fila = new FilaLigada<>();
        fila.insert(10);
        fila.insert(20);
        fila.insert(30);

        fila.exibe();
        System.out.println("Primeiro elemento da fila: " + fila.peek());
        System.out.println("Removendo elemento da fila: " + fila.poll());
        fila.exibe();
    }
}
