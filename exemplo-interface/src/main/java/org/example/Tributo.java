package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tributo {

    List<Tributavel> listaTrib;

    public Tributo() {
        this.listaTrib = new ArrayList<>();
    }

    public void adicionaTributavel(Tributavel t){
        listaTrib.add(t);
    }

    public double calculaTotalTributo(){
        double total = 0;
        for (Tributavel t : listaTrib){
            total += t.getValorTributo();
        }
        return total;
    }

    public void exibeTodos(){
        for (Tributavel t : listaTrib){
            System.out.println(t.toString());
        }
    }
}
