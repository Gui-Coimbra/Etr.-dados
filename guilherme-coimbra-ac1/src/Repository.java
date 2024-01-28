public class Repository {

    private Node head;


    public Repository() {
        head = new Node(' ');
    }

    public void addAtEnd(char value) {
        Node novo = new Node(value);
        Node atual = head.getNext();
        Node ant = head;
        while (atual != null){
            ant = atual;
            atual = atual.getNext();
        }
        atual = novo;
        ant.setNext(atual);
    }

    public void addAfterSpace(char value){
        Node novo = new Node(value);
        Node atual = head.getNext();
        while (atual != null) {
                if (atual.getInfo() == ' ') {
                    novo.setNext(atual.getNext());
                    atual.setNext(novo);
                    return;
                }
                atual = atual.getNext();
            }
    }

    public void addAtIndex(int index, char value){
        Node atual = head.getNext();
        Node ant = head;
        Node novo = new Node(value);
        int indice = 0;
        boolean encontrou = false;
        while (atual != null){
            if (indice == index){
                novo.setNext(atual);
                ant.setNext(novo);
                encontrou = true;
                break;
            }
            ant = atual;
            atual = atual.getNext();
            indice ++;
        }
        if (encontrou == false){
            System.out.println("A lista é menor do que o indice informado");
        }
    }

    public void duplicateValue(char value) {
        Node ant = head;
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo() == value) {
                Node novo = new Node(value);
                novo.setNext(atual);
                ant.setNext(novo);
            }
            ant = atual;
            atual = atual.getNext();
        }
    }

    public void removeDuplicate(char value){
        Node atual = head.getNext();
        Node ant = head;
        while (atual != null) {
            if (ant.getInfo() == value && atual.getInfo() == value) {
                ant.setNext(atual.getNext());
            }
            ant = atual;
            atual = atual.getNext();
        }
    }

    public void show() {
        Node atual = head.getNext();
        StringBuilder lista = new StringBuilder();
        while (atual != null) {
            lista.append(atual.getInfo());
            atual = atual.getNext();
        }
        System.out.println(lista);
    }

    public void showRecursivo() {
        Node atual = head.getNext();
        showRecursivoAux(atual);
    }

    private StringBuilder showRecursivoAux(Node atual) {
        if (atual == null) {
            return null;
        }else{
            System.out.println(atual.getInfo());
        }
        return showRecursivoAux(atual.getNext());
    }

//    countWords(): retorna a quantidade de palavras que existem na lista. Para simplificar, pode supor que
//    não haverá caracteres espaços duplicados e nem caractere espaço no início da lista, logo após o head, e
//    nem no final.
//    Por exemplo: se a lista estiver assim:
//    head ->  'a'  ->  'r'  ->  'r'  ->  'a'  ->  'n'  -> 'h'  ->  'a'  ->  ' '  ->  'o'  -> ' '  ->  'j'  ->
//    'a'  ->  'r'  ->  'r'  ->  'o'
//    A chamada do método countWords() retornará 3.
//
//    Outro exemplo: se a lista estiver assim:
//    head ->  'j'  ->  'a'  ->  'r'  ->  'r'  ->  'o'
//    A chamada do método countWords() retornará 1.
//
//    Outro exemplo: se a lista estiver assim:
//    head ->  'j'  ->  'a'  ->  'r'  ->  'r'  ->  'o' -> ' ' -> 'f' -> 'e' -> 'i' -> 'o'
//    A chamada do método countWords() retornará 2.

//    public int countWords() {
//        Node atual = head.getNext();
//        Node ant = head;
//        while (atual != null) {
//            int qtd = 0;
//            if(atual.getInfo() != ' ' && atual.getInfo() != ant.getInfo()){
//                qtd++;
//            }
//            if()
//            atual = atual.getNext();
//        }
//        return qtd;
//    }
}