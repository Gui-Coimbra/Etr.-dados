public class FilaPilha {
    private int[] filaPilha;
    private int topo;
    private int tamanho;

    public FilaPilha(int capacidade) {
        this.filaPilha = new int[capacidade];
        this.topo = capacidade;
        this.tamanho = 0;
    }

    public boolean isEmpty(){
        return tamanho == 0 && topo == filaPilha.length;
    }

    public boolean isFull(){
        return tamanho == topo-1;
    }

    public void insert(int info) {
        if (isFull()) {
            System.out.println("Pilha cheia");
        }
        else {
            filaPilha[tamanho++] = info;
        }

    }

    public int peekFila() {
        return filaPilha[0];
    }
    public int peekPilha() {
        return filaPilha[topo];
    }

    public int poll() {
        int primeiro = filaPilha[0];

        if (!isEmpty()) {
            for (int i = 0; i < tamanho - 1; i++) {
                filaPilha[i] = filaPilha[i+1];
            }
            tamanho--;
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
        return filaPilha.length;
    }

    public void push(int info) {
        if(isFull()){
            System.out.println("Pilha cheia!");
            return;
        }
        filaPilha[--topo] = info;
    }

    public int pop() {
        if (!isEmpty()) {
            return filaPilha[topo++];
        }
        return 0;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Vetor vazio");
        }
        else {
            System.out.println("Conteúdo da fila:");
            for (int i = 0; i < tamanho;i++) {
                System.out.println(filaPilha[i]);
            }
            System.out.println("Conteúdo da pilha:");
            for (int i = topo; i <= filaPilha.length-1; i++) {
                System.out.println(filaPilha[i]);
            }
        }
    }

    public void exibeRecursivoFila() {
        exibeRecursivoFilaAux(0);
    }

    private void exibeRecursivoFilaAux(int index) {
        if (index < tamanho) {
            System.out.println(filaPilha[index]);
            exibeRecursivoFilaAux(index + 1);
        }
    }

    public void exibeRecursivoPilha() {
        exibeRecursivoPilhaAux(topo);
    }

    private void exibeRecursivoPilhaAux(int index) {
        if (index <= filaPilha.length-1) {
            System.out.println(filaPilha[index]);
            exibeRecursivoPilhaAux(index + 1);
        }
    }
}