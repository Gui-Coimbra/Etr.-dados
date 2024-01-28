public class Heap {

    public int paiF(int f){
        if(f % 2 != 0){
            return (f-1)/2;
        }else{
            return (f-2)/2;
        }
    }

    public void troca(int a, int b, int v[]){
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }

    public void insereEmHeap(int m, int v[]){
        int f = m + 1;
        int p = paiF(f);
        while (f > 0 && v[p] < v[f]) {
            int aux = v[p];
            v[p] = v[f];
            v[f] = aux;
            f = p;
            p = paiF(f);
        }
    }

    public void ajustaHeap(int m, int v[]){
        int f = 1;
        while(f <= m){
            if (f < m && v[f] < v[f+1]){
                f++;
            }
            int p = paiF(f);
            if(v[p] >= v[f]){
                break;
            }
            int aux = v[p];
            v[p] = v[f];
            v[f] = aux;
            f = (f*2) + 1;
        }
    }

    public void heapSort(int v[]){
        int m;
        for(m = 0; m <= v.length-2; m++){
            insereEmHeap(m, v);
        }
        for(m = v.length-1; m >= 0; m--){
            int aux = v[0];
            v[0] = v[m];
            v[m] = aux;
            ajustaHeap(m-1, v);
        }
    }
}
