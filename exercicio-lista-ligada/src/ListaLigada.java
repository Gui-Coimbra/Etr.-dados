public class ListaLigada {

    private Node head;

    public ListaLigada() {
        this.head = new Node(0);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insereNode(int valor){
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }

    public void exibe(){
        Node atual =  head.getNext();
        while(atual != null){
            System.out.println(atual.getInfo());
            atual=atual.getNext();
        }
    }

    public Node buscaNode(int valor){
        Node atual = head.getNext();
        while(atual != null){
            if(atual.getInfo() == valor){
                return atual;
            }else{
                atual = atual.getNext();
            }
        }
        return null;
    }

    public boolean removeNode(int valor){
        Node anterior = head;
        Node atual = head.getNext();
        while(atual != null){
            if(atual.getInfo() == valor){
                anterior.setNext(atual.getNext());
                return true;
            }else{
                anterior = atual;
                atual = atual.getNext();
            }
        }
        return false;
    }

    public int getTamanho(){
        Node atual = head.getNext();
        int tamanho = 0;
        while(atual != null){
            tamanho++;
            atual = atual.getNext();
        }
        return tamanho;
    }

    public void concatena(ListaLigada lista) {
        Node atual = this.head;
        while (atual.getNext() != null) {
            atual = atual.getNext();
        }
        if (lista.getHead().getNext() != null) {
            atual.setNext(lista.getHead().getNext());
        }
    }

    public boolean compara(ListaLigada lista) {
        Node atual1 = this.head.getNext();
        Node atual2 = lista.getHead().getNext();

        while (atual1 != null && atual2 != null) {
            if (atual1.getInfo() != atual2.getInfo()) {
                return false;
            }
            atual1 = atual1.getNext();
            atual2 = atual2.getNext();
        }

        return atual1 == null && atual2 == null;
    }

    public void inverte() {
        Node anterior = null;
        Node atual = this.head.getNext();
        Node proximo = null;

        while (atual != null) {
            proximo = atual.getNext();
            atual.setNext(anterior);
            anterior = atual;
            atual = proximo;
        }

        this.head.setNext(anterior);
    }

    public void exibeRecursivo(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getInfo());
        exibeRecursivo(node.getNext());
    }

    public Node buscaNodeRecursivo(Node node, int valor) {
        if (node == null) {
            return null;
        }
        if (node.getInfo() == valor) {
            return node;
        }
        return buscaNodeRecursivo(node.getNext(), valor);
    }

    public boolean removeNodeRecursivo(Node anterior, Node atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (atual.getInfo() == valor) {
            anterior.setNext(atual.getNext());
            return true;
        }
        return removeNodeRecursivo(atual, atual.getNext(), valor);
    }

    public int getTamanhoRecursivo(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getTamanhoRecursivo(node.getNext());
    }
}
