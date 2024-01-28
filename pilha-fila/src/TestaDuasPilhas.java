public class TestaDuasPilhas {
    public static void main(String[] args) {

        DuasPilhas pilha = new DuasPilhas(10);
        int[] vetor = {1, 5, 2, -3, 7, -10, 8, 25, -14, 15};
        for(int i : vetor){
            if(i >= 0){
                pilha.push(i, 1);
            }else {
                pilha.push(i, 2);
            }
        }
        pilha.exibe();

        pilha.exibeRecursivo1();
        pilha.exibeRecursivo2();


        while(!pilha.isEmpty(1)){
            pilha.pop(1);
        }
        while(!pilha.isEmpty(2)){
            pilha.pop(2);
        }
    }
}