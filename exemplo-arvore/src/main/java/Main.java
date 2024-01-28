public class Main {
    public static void main(String[] args) {

        ArvoreBin arvore = new ArvoreBin();
        arvore.criaRaiz(6);
        Node no4 = arvore.insereEsq(arvore.getRaiz(), 4);
        Node no8 = arvore.insereDir(arvore.getRaiz(), 8);
        Node no2 = arvore.insereEsq(no4, 2);
        Node no5 = arvore.insereDir(no4, 5);
        Node no1 = arvore.insereEsq(no2, 1);
        Node no3 = arvore.insereDir(no2, 3);
        Node no7 = arvore.insereEsq(no8, 7);
        Node no9 = arvore.insereDir(no8, 9);

        arvore.exibeArvore(arvore.getRaiz());
    }
}
