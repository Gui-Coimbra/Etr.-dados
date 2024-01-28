public class Node {

    private int info;
    private Node esq;
    private Node dir;

    public Node(int info) {
        this.info = info;
        this.esq = null;
        this.dir = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }
}

//        Construtor: Node (int info)
//        • Atribui o valor do info
//        • Atribui null para esq e dir
//        Setters e getters