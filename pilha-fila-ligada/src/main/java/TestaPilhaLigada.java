public class TestaPilhaLigada {
    public static void main(String[] args) {
        PilhaLigada pilhaLigada = new PilhaLigada<>();

        System.out.println(pilhaLigada.isEmpty());

        pilhaLigada.push(10);
        pilhaLigada.push(15);
        pilhaLigada.push(5);
        pilhaLigada.push(2);
        pilhaLigada.push(42);

        System.out.println(pilhaLigada.isEmpty());

        System.out.println("-".repeat(20));
        pilhaLigada.exibe();
        System.out.println("-".repeat(20));

        System.out.println(pilhaLigada.peek());
        System.out.println(pilhaLigada.pop());
        System.out.println(pilhaLigada.peek());

    }
}
