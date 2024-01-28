public class TesteComString {
    public static void main(String[] args) {
        ListaLigada<String> lista = new ListaLigada<>();
        lista.insereNode("A");
        lista.insereNode("B");
        lista.insereNode("C");
        lista.exibe();

        PilhaLigada<String> pilha = new PilhaLigada<>();
        pilha.push("X");
        pilha.push("Y");
        pilha.push("Z");
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo da pilha: " + pilha.pop());

        FilaLigada<String> fila = new FilaLigada<>();
        fila.insert("1");
        fila.insert("2");
        fila.insert("3");
        System.out.println("Frente da fila: " + fila.peek());
        System.out.println("Removendo da fila: " + fila.poll());
    }
}
