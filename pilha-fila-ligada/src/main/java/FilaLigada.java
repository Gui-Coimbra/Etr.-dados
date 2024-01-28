public class FilaLigada<T> {

    private Node<T> inicio;
    private Node<T> fim;

    public FilaLigada() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty(){
        return inicio == null;
    }

    public void insert(T valor) {
        Node<T> novo = new Node(valor);
        if(isEmpty()){
            inicio = novo;
            fim = novo;
        }else {
            fim.setNext(novo);
            fim = novo;
        }
    }

    public void exibe(){
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        } else {
            System.out.println("Conteúdo da fila:");
            Node<T> atual = inicio;
            while (atual != null) {
                System.out.println(atual.getInfo());
                atual = atual.getNext();
            }
        }
    }


    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Fila vazia");
        }
        return inicio.getInfo();
    }


    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia!");
        }
        T primeiro = inicio.getInfo();
        inicio = inicio.getNext();
        if (inicio == null) {
            fim = null;
        }
        return primeiro;
    }

}