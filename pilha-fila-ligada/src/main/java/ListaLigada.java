public class ListaLigada<T> {

    private Node<T> head;


    public ListaLigada() {
        head = new Node<>(null);
    }


        public void insereNode(T valor) {
            Node<T> novo = new Node(valor);
            novo.setNext(head.getNext());
            head.setNext(novo);
        }

        public void exibe()
        {
            Node<T> atual = head.getNext();
            while (atual != null) {
                System.out.println(atual.getInfo());
                atual = atual.getNext();
            }
        }
        public Node<T> buscaNode(T valor) {
            Node<T> atual = head.getNext();
            while (atual != null) {
                if (atual.getInfo() == valor) {
                    return atual;
                }
                atual = atual.getNext();
            }
            return null;
        }
        public Boolean removeNode(T valor) {
            Node<T> ant = head;
            Node<T> atual = head.getNext();
            while (atual != null) {
                if (atual.getInfo() == valor) {
                    ant.setNext(atual.getNext());
                    return true;
                }
                ant = atual;
                atual = atual.getNext();
            }
            return false;
        }

        public int getTamanho() {
            Node<T> atual = head.getNext();
            int tam = 0;
            while (atual != null) {
                tam++;
                atual = atual.getNext();
            }
            return tam;
        }
//        public void inserirAposPrimeiroImpar(int valor){
//            Node novo = new Node(valor);
//            Node atual = head.getNext();
//            while (atual != null) {
//                if (atual.getInfo() % 2 != 0) {
//                    novo.setNext(atual.getNext());
//                    atual.setNext(novo);
//                    return;
//                }
//                atual = atual.getNext();
//            }
//        }
//        public T getElemento(int indice) {
//            Node<T> atual = head.getNext();
//            int i = 0;
//            while (atual != null) {
//                if (i == indice) {
//                    return atual.getInfo();
//                }
//                i++;
//                atual = atual.getNext();
//            }
//            return -1;
//        }
        public boolean removeOcorrencias(T valor) {
            Node<T> ant = head;
            Node<T> atual = head.getNext();
            boolean removeu = false;
            while (atual != null) {
                if (atual.getInfo() == valor) {
                    ant.setNext(atual.getNext());
                    removeu = true;
                } else {
                    ant = atual;
                }
                atual = atual.getNext();
            }
            return removeu;
        }

        public void arrayToList(T[] vetor) {

            if (head.getNext() != null) {
                System.out.println("Operação inválida");
                return;
            } else {
                for (int i = 0; i < vetor.length; i++) {
                    insereNode(vetor[i]);
                }
                System.out.println();

            }

        }
}
