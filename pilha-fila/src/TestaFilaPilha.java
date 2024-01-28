public class TestaFilaPilha {
    public static void main(String[] args) {

        FilaPilha fp = new FilaPilha(10);
        int[] vetor = {1, 5, 2, -3, 7, -10, 8, 25, -14, 15};
        for(int i : vetor){
            if(i >= 0){
                fp.push(i);
            }else {
                fp.insert(i);
            }
        }

        fp.exibe();

        System.out.println("-".repeat(30));
//        System.out.println("Exibe fila");
//        fp.exibeRecursivoFila();
//        System.out.println("Exibe pilha");
//        fp.exibeRecursivoPilha();

        while(fp.getTamanho() > 0){
            System.out.println(fp.poll());
        }
        while(fp.getTopo() < fp.getCapacidade()){
            System.out.println(fp.pop());
        }
    }
}
