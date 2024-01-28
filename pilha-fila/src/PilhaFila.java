public class PilhaFila {

    private int[] pilhaFila;
    private int topo;
    private int tamanho;

    public PilhaFila(int capacidade) {
        this.pilhaFila = new int[capacidade];
        this.topo = -1;
        this.tamanho = capacidade-1;
    }

    public boolean isEmpty(){
        return tamanho == pilhaFila.length-1 && topo == -1;
    }

    public boolean isFull(){
        return tamanho == topo;
    }

    public void insert(int info) {
        if (isFull()) {
            System.out.println("Fila cheia");
        }
        else {
            pilhaFila[tamanho--] = info;
        }

    }

    public int peekFila() {
        return pilhaFila[pilhaFila.length-1];
    }
    public int peekPilha() {
        return pilhaFila[topo];
    }

    public int poll() {
        int primeiro = pilhaFila[pilhaFila.length-1];

        if (!isEmpty()) {
            for (int i = pilhaFila.length-1; i > tamanho + 1; i--) {
                pilhaFila[i] = pilhaFila[i-1];
            }
            tamanho++;
        }

        return primeiro;
    }

    public int getTamanho(){
        return tamanho;
    }

    public int getTopo() {
        return topo;
    }
    public int getCapacidade() {
        return pilhaFila.length;
    }

    public void push(int info) {
        if(isFull()){
            System.out.println("Pilha cheia!");
            return;
        }
        pilhaFila[++topo] = info;
    }

    public int pop() {
        if (!isEmpty()) {
            return pilhaFila[topo--];
        }
        return 0;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Vetor vazio");
        }
        else {
            System.out.println("Conteúdo da pilha:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilhaFila[i]);
            }
            System.out.println("Conteúdo da fila:");
            for (int i = pilhaFila.length-1; i > tamanho;i--) {
                System.out.println(pilhaFila[i]);
            }
        }
    }

    public void exibeRecursivoPilha() {
        exibeRecursivoPilhaAux(topo);
    }

    private void exibeRecursivoPilhaAux(int index) {
        if (index >= 0) {
            System.out.println(pilhaFila[index]);
            exibeRecursivoPilhaAux(index - 1);
        }
    }

    public void exibeRecursivoFila() {
        exibeRecursivoFilaAux(pilhaFila.length-1);
    }

    private void exibeRecursivoFilaAux(int index) {
        if (index > tamanho) {
            System.out.println(pilhaFila[index]);
            exibeRecursivoFilaAux(index - 1);
        }
    }
}
