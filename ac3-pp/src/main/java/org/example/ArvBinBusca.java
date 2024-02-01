package org.example;

public class ArvBinBusca {
    private Node raiz;

    public ArvBinBusca() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void insere(Aluno aluno){
        if(getRaiz() == null){
            this.raiz = new Node(aluno);
        }else{
            Node alunoDaVez = getRaiz();
            while (alunoDaVez != null && alunoDaVez.getInfo() != aluno){
                Node novo = new Node(aluno);
                if(aluno.getMedia() <= alunoDaVez.getInfo().getMedia()){
                    if(alunoDaVez.getEsq() == null){
                        alunoDaVez.setEsq(novo);
                    }
                    alunoDaVez = alunoDaVez.getEsq();
                }else{
                    if(alunoDaVez.getDir() == null){
                        alunoDaVez.setDir(novo);
                    }
                    alunoDaVez = alunoDaVez.getDir();
                }
            }
        }
    }

    public void preOrdem(Node daVez){
        if(daVez != null) {
            System.out.print(daVez.getInfo() + "\t");
            preOrdem(daVez.getEsq());
            preOrdem(daVez.getDir());
        }
    }

    public void emOrdem(Node daVez){
        if(daVez != null) {
            emOrdem(daVez.getEsq());
            System.out.print(daVez.getInfo() + "\t");
            emOrdem(daVez.getDir());
        }
    }

    public void posOrdem(Node daVez){
        if(daVez != null) {
            posOrdem(daVez.getEsq());
            posOrdem(daVez.getDir());
            System.out.print(daVez.getInfo() + "\t");
        }
    }

    public Node buscaNo(Aluno aluno, Node daVez){
        if(daVez == null || daVez.getInfo() == aluno){
            return daVez;
        }
        if(aluno.getMedia() < daVez.getInfo().getMedia()){
            return buscaNo(aluno, daVez.getEsq());
        }else{
            return buscaNo(aluno, daVez.getDir());
        }
    }

}
