public class ListaLigadaOrdenada extends ListaLigada {

    public ListaLigadaOrdenada() {
        super();
    }

    @Override
    public void exibe() {
        Node atual = getHead().getNext();

        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }

    @Override
    public void insereNode(int valor) {
        Node novo = new Node(valor);
        Node anterior = null;
        Node atual = getHead().getNext();

        while (atual != null) {
            if (valor < atual.getInfo()) {
                novo.setNext(atual);
                if (anterior != null) {
                    anterior.setNext(novo);
                } else {
                    getHead().setNext(novo);
                }
                return;
            }
            anterior = atual;
            atual = atual.getNext();
        }

        if (anterior != null) {
            anterior.setNext(novo);
        } else {
            getHead().setNext(novo);
        }
    }


    @Override
    public Node buscaNode(int valor) {
        Node atual = getHead().getNext();

        while (atual != null) {
            if (atual.getInfo() == valor) {
                return atual;
            } else if (atual.getInfo() > valor) {
                break;
            }
            atual = atual.getNext();
        }

        return null;
    }

    @Override
    public boolean removeNode(int valor) {
        Node anterior = getHead();
        Node atual = getHead().getNext();

        while (atual != null) {
            if (atual.getInfo() == valor) {
                anterior.setNext(atual.getNext());
                return true;
            } else if (atual.getInfo() > valor) {
                break;
            }
            anterior = atual;
            atual = atual.getNext();
        }

        return false;
    }
}