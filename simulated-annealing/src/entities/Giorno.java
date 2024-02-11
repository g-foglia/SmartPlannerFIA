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

    public void setImpegno(Impegno impegno, int fascia){
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

    public int getTotalMalus(){
        Impegno impegno0 = impegni.get(7);
        Impegno impegno1 = impegni.get(8);
        Impegno impegno2 = impegni.get(9);

        int zero = 0;
        int uno = 0;
        int due = 0;

        if(impegno0 != null) zero = 1;
        if(impegno1 != null) uno = 1;
        if(impegno2 != null) due = 1;

        if(zero == 0 && uno == 0 && due ==0) return 0;
        else if(zero == 0 && uno == 0 && due ==1) return (impegno2.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==0) return (impegno1.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==1) return (impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==0) return (impegno0.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==1) return (impegno0.getPrioritaImpegno() + impegno2.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==0) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==1) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno());

        return 0;
    }

    public int getTotalBen(){
        Impegno impegno0 = impegni.get(1);
        Impegno impegno1 = impegni.get(2);
        Impegno impegno2 = impegni.get(10);
        Impegno impegno3 = impegni.get(11);

        int zero = 0;
        int uno = 0;
        int due = 0;
        int tre = 0;

        if(impegno0 != null) zero = 1;
        if(impegno1 != null) uno = 1;
        if(impegno2 != null) due = 1;
        if(impegno3 != null) tre = 1;

        if(zero == 0 && uno == 0 && due ==0 && tre == 0) return 0;
        else if(zero == 0 && uno == 0 && due ==0 && tre == 1) return (impegno3.getPrioritaImpegno());
        else if(zero == 0 && uno == 0 && due ==1 && tre == 0) return (impegno2.getPrioritaImpegno());
        else if(zero == 0 && uno == 0 && due ==1 && tre == 1) return (impegno2.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==0 && tre == 0) return (impegno1.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==0 && tre == 1) return (impegno1.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==1 && tre == 0) return (impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno());
        else if(zero == 0 && uno == 1 && due ==1 && tre == 1) return (impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==0 && tre == 0) return (impegno0.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==0 && tre == 1) return (impegno0.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==1 && tre == 0) return (impegno0.getPrioritaImpegno() + impegno2.getPrioritaImpegno());
        else if(zero == 1 && uno == 0 && due ==1 && tre == 1) return (impegno0.getPrioritaImpegno() + impegno2.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==0 && tre == 0) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==0 && tre == 1) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno() + impegno3.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==1 && tre == 0) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno());
        else if(zero == 1 && uno == 1 && due ==1 && tre == 1) return (impegno0.getPrioritaImpegno() + impegno1.getPrioritaImpegno() + impegno2.getPrioritaImpegno() + impegno3.getPrioritaImpegno());

        return 0;
    }

    @Override
    public String toString() {
        String[] fasce = {"8-9","9-10","10-11","11-12","12-13","13-14","14-15","15-16","16-17","17-18","18-19","19-20"};
        String toString = nome + ": ";

        for(int i = 0; i < impegni.size(); i++){
            if(impegni.get(i) != null)
                toString = toString.concat(impegni.get(i).toString() + " " + fasce[i] + " | ");
        }
        return toString;
    }

}
