public class ArvoreBin {
    private Node raiz;

    public ArvoreBin() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void criaRaiz(int info){
        Node novo = new Node(info);
        this.raiz = novo;
    }

    public Node insereDir(Node pai, int info){
        if(raiz != null && pai.getDir() == null){
            Node novo = new Node(info);
            pai.setDir(novo);
            return novo;
        }
        return null;
    }

    public Node insereEsq(Node pai, int info){
        if(raiz != null && pai.getEsq() == null){
            Node novo = new Node(info);
            pai.setEsq(novo);
            return novo;
        }
        return null;
    }

    public void exibeArvore(Node noDaVez){
        if(noDaVez != null){
            System.out.print(noDaVez.getInfo() + " ");
            if(noDaVez.getEsq() != null){
                System.out.print(noDaVez.getEsq().getInfo() + " ");
            }else{
                System.out.print("null ");
            }
            if(noDaVez.getDir() != null){
                System.out.print(noDaVez.getDir().getInfo());
            }else{
                System.out.print("null ");
            }
            System.out.println();
            exibeArvore(noDaVez.getEsq());
            exibeArvore(noDaVez.getDir());
        }
    }

    public void preOrdem(){

    }

    public void emOrdem(){

    }

    public void posOrdem(){

    }
}

//1- Implementar os métodos preOrdem, emOrdem, posOrdem, para visitar e exibir os valores
//  dos elementos dos nós da árvore em pré-ordem, em-ordem e pós-ordem.
//  Implementar a versão recursiva e a versão iterativa de cada um.
//2- Implementar o método que devolve a profundidade da árvore.
//3- Implementar o método que devolve a altura de um nó qualquer da árvore.
// 4- Implementar o método que busca o nó da árvore binária que contém um determinado valor.
//        Esse método retorna o endereço desse nó