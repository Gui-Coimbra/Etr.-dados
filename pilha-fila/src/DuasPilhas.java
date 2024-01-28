public class DuasPilhas {

    private int[] pilha;
    private int topo1;
    private int topo2;

    public DuasPilhas(int capacidade) {
        this.topo1 = -1;
        this.topo2 = capacidade;
        this.pilha = new int[capacidade];
    }

    public Boolean isEmpty(int opcao) {
        if(opcao == 1) {
            return topo1 == -1;
        }else {
            return topo2 == this.pilha.length;
        }
    }

    public Boolean isFull() {
        return topo1 == topo2-1;
    }

    public void push(int info, int opcao) {
        if(isFull()){
            System.out.println("Pilha cheia!");
            return;
        }
        if(opcao == 1) {
            pilha[++topo1] = info;
        }else if(opcao == 2){
            pilha[--topo2] = info;
        }else{
            System.out.println("Informe uma opção correta");
        }
    }

    public int pop(int opcao) {
            if (!isEmpty(opcao)) {
                if(opcao == 1) {
                    return pilha[topo1--];
                }
                    return pilha[topo2++];
            }
            return 0;
    }

    public int peek(int opcao){
        if(opcao == 1){
            return pilha[topo1];
        }
        return pilha[topo2];
    }

    public void exibe(){
        if(isEmpty(1) && isEmpty(2)) {
            System.out.println("Pilha vazia!");

        }else{
            System.out.println("Pilha 1: ");
            for (int i = topo1; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
            System.out.println("Pilha 2: ");
            for (int i = topo2; i <= pilha.length-1; i++) {
                System.out.println(pilha[i]);
            }
        }
    }

    public void exibeRecursivo1() {
        exibeRecursivo1Aux(topo1);
    }

    private void exibeRecursivo1Aux(int index) {
        if (index >= 0) {
            System.out.println(pilha[index]);
            exibeRecursivo1Aux(index - 1);
        }
    }

    public void exibeRecursivo2() {
        exibeRecursivo2Aux(topo2);
    }

    private void exibeRecursivo2Aux(int index) {
        if (index <= pilha.length-1) {
            System.out.println(pilha[index]);
            exibeRecursivo2Aux(index + 1);
        }
    }
}
