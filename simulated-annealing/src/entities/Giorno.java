package entities;

import java.util.ArrayList;

public class Giorno {

    private String nome;
    private ArrayList<Impegno> impegni = new ArrayList<>();


    public Giorno(String nome){

        this.nome = nome;
        for(int i = 0; i < 12; i++){
            impegni.add(null);
        }

    }

    public void setImpegni(Impegno impegno, int fascia){
        impegni.set(fascia, impegno);
    }

    public Impegno getImpegnoByFascia(int fascia){
        return impegni.get(fascia);
    }

    public boolean isEmpty(){
        return impegni.isEmpty();
    }

    public int getTotalScore(){
        int tot = 0;
        if(this.isEmpty()) return tot;

        for(int i = 0; i < impegni.size(); i++){
            if(impegni.get(i) != null)
                tot += impegni.get(i).getPrioritaImpegno();
        }
        return tot;
    }

    //implemento i malus e i bonus
}
