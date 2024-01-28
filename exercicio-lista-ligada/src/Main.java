public class Main {

    public static void encontrar(Node encontrado){
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getInfo());
        } else {
            System.out.println("Não encontrado.");
        }
    }
    public static void main(String[] args) {
        ListaLigadaOrdenada listaOrdenada = new ListaLigadaOrdenada();

        listaOrdenada.insereNode(5);
        listaOrdenada.insereNode(2);
        listaOrdenada.insereNode(7);
        listaOrdenada.insereNode(1);

        listaOrdenada.exibe();

        Node encontradoOrd = listaOrdenada.buscaNode(2);
        Node encontradoOrd2 = listaOrdenada.buscaNode(4);
        encontrar(encontradoOrd);
        encontrar(encontradoOrd2);


        listaOrdenada.removeNode(2);
        listaOrdenada.exibe();

        ListaLigada lista = new ListaLigada();
        lista.insereNode(10);
        lista.insereNode(7);
        lista.insereNode(15);
        lista.insereNode(2);

        System.out.println("Exibindo a lista ligada:");
        lista.exibeRecursivo(lista.getHead().getNext());

        int valorBuscado = 15;
        Node encontrado = lista.buscaNodeRecursivo(lista.getHead().getNext(), valorBuscado);
        encontrar(encontrado);

        int valorRemover = 7;
        if (lista.removeNodeRecursivo(lista.getHead(), lista.getHead().getNext(), valorRemover)) {
            System.out.println("Valor " + valorRemover + " removido com sucesso.");
        } else {
            System.out.println("Valor " + valorRemover + " não encontrado.");
        }

        System.out.println("Tamanho da lista: " + lista.getTamanhoRecursivo(lista.getHead().getNext()));

        System.out.println("Exibindo a lista invertida:");
        lista.inverte();
        lista.exibeRecursivo(lista.getHead().getNext());
    }

}
