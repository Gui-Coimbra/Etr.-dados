public class Node<T> {

    // Atributos
    private T info;
    private Node<T> next;

    // Construtor
    public Node (T info) {
        this.info = info;
        next = null;
    }

    // Métodos

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
