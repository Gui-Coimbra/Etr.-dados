import java.util.ArrayList;

public class FilaPrioridade {

    private ArrayList<Jogador> heap;
    private int tamanho;

    public FilaPrioridade(int capacidade) {
        this.heap = new ArrayList<>(capacidade);
        this.tamanho = 0;
    }

    public boolean isFull(){
        return tamanho == heap.size();
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void inserir(Jogador jogador){
        if(isFull()){
            throw new IllegalStateException();
        }else if (isEmpty()){
            heap.add(jogador);
            tamanho++;
        }
    }
}

//- inserir - recebe como argumento um objeto da ClasseTema - verifica se há espaço no
// vetor heap e se não tiver espaço, exibe uma mensagem (ou lança uma exception) - se a
// fila está vazia, apenas insere no primeiro índice da fila e incrementa tamanho, senão,
// se houver espaço, coloca no primeiro espaço livre do vetor (índice tamanho) e depois
// rearranja o heap para que fique um max-heap considerando a prioridade como critério
// (parecido com o insereEmHeap). Não se esqueça de incrementar tamanho.
//
//        - remover - não recebe argumento e retorna o objeto de ClasseTema de maior
//        prioridade na fila. Se a fila estiver vazia, retorna null, senão troca o valor
//        de maior prioridade na fila (índice zero) com o último valor da árvore (índice
//        tamanho-1). Rearranja o heap para que fique um max-heap. Não se esqueça de
//        decrementar tamanho. Retorna o valor de heap, índice tamanho (se já decrementou o
//        tamanho).
//
//        - exibir - exibe os objetos que estão no heap
//
//        Classe Main, no método main:
//
//        - Crie uma fila do tipo Fila de Prioridade (defina a capacidade conforme desejar)
//
//        - Fique num loop exibindo o menu:
//        1- Inserir
//        2- Remover
//        3- Exibir
//        4- Fim
//
//        Se o usuário escolher:
//        Opção 1: solicite que o usuário digite os valores dos atributos da classe Tema,
//        instancie um objeto da classe Tema e chame o método inserir da fila de prioridade
//        Opção 2: exiba o retorno do método remover da fila de prioridade
//        Opção 3: exiba o conteúdo da fila de prioridade
//        Opção 4: encerre o programa
//        Qualquer outra opção diferente de 1, 2, 3, 4, exiba a mensagem "opção inválida" e
//        continue no loop.
