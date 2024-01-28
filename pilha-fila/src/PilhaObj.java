public class PilhaObj<T> {
    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length-1;
    }

    public void push(T info) {
        if(isFull()){
            System.out.println("Pilha cheia!");
            return;
        }
        pilha[++topo] = info;
    }

    public void exibe(){
        if(isEmpty()) {
            System.out.println("Pilha vazia!");

        }else{
            for (T i : pilha) {
                System.out.println((i));
            }
        }
    }

    public T pop() {
        if(!isEmpty()) {
            return pilha[topo--];
        }
        return null;
    }

    public void fraseInvertida(String frase){
        Character[] pilha = new Character[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            pilha[i] = frase.charAt(i);
        }
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.print(pilha[i]);
        }
    }

    public int getTopo() {
        return topo;
    }
}
