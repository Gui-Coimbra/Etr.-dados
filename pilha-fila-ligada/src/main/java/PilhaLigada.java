public class PilhaLigada<T> {
    private Node<T> topo;

    public PilhaLigada() {
        topo = new Node<T>(null);
    }

    public boolean isEmpty(){
        return topo.getNext() == null;
    }

    public void push(T valor) {
        Node novo = new Node(valor);
        novo.setNext(topo.getNext());
        topo.setNext(novo);
    }


    public void exibe(){
        Node atual = topo.getNext();
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getNext();
        }
    }


    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Pilha vazia");
        }
        return (T) topo.getNext().getInfo();
    }


    public T pop() {
       Node atual = topo.getNext();
       topo.setNext(atual.getNext());
       return (T) atual.getInfo();
    }
}

//1) Implementar a classe PilhaLigada, que é a implementação da pilha usando lista encadeada,
//        mas sem reutilizar a classe ListaLigada. Pode usar a classe Node, que criamos para a
//        ListaLigada.
//        a. Pense em como será o atributo topo.
//        b. Implemente os métodos isEmpty, push, pop, peek, exibe.
//        c. Implemente a classe executável onde é criado um objeto PilhaLigada e chame os
//        métodos para ver se está funcionando.

