public class TestaPilhaFila {

    public static void main(String[] args) {

        PilhaFila pf = new PilhaFila(10);
        int[] vetor = {1, 5, 2, -3, 7, -10, 8, 25, -14, 15};
        for(int i : vetor){
            if(i >= 0){
                pf.insert(i);
            }else {
                pf.push(i);
            }
        }

        pf.exibe();

        System.out.println("-".repeat(30));
//        System.out.println("Exibe pilha");
//        pf.exibeRecursivoPilha();
//        System.out.println("Exibe fila");
//        pf.exibeRecursivoFila();

        while(pf.getTamanho() < pf.getCapacidade()-1){
            System.out.println(pf.poll());
        }
        while(pf.getTopo() >= 0){
            System.out.println(pf.pop());
        }
    }
}
