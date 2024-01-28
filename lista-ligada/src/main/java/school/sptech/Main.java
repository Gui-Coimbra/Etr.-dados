package school.sptech;

public class Main {
    public static void main(String[] args) {
        ListaLigada listaLigada = new ListaLigada();

        listaLigada.insereNode(4);
        listaLigada.insereNode(6);
        listaLigada.insereNode(2);
        listaLigada.insereNode(9);
        listaLigada.insereNode(23);

        listaLigada.exibe();

        System.out.println("-".repeat(30));

        System.out.println(listaLigada.buscaNode(3));
        System.out.println("-".repeat(30));
        System.out.println(listaLigada.buscaNode(4));

        System.out.println("-".repeat(30));
        System.out.println(listaLigada.removeNode(23));

        System.out.println("-".repeat(30));
        listaLigada.exibe();

    }
}