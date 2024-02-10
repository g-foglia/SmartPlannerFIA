package individuals;

import java.util.ArrayList;

public class Settimana {
    private ArrayList<Giorno> settimana = new ArrayList<>();
    private int fitness;

    public Settimana(){
        settimana.add(new Giorno("Lunedì"));
        settimana.add(new Giorno("Martedì"));
        settimana.add(new Giorno("Mercoledì"));
        settimana.add(new Giorno("Giovedì"));
        settimana.add(new Giorno("Venerdì"));
        settimana.add(new Giorno("Sabato"));
        settimana.add(new Giorno("Domenica"));
    }

    public Giorno getGiorno(int index){
        return settimana.get(index);
    }

    //un indice è in forma x.yy, la x rappresenta il giorno (0-6) e la y la fascia (0-11)
    public void setImpegno(Impegno impegno, String index){
        int giorno = Integer.parseInt(index.substring(0,1));
        int fascia = Integer.parseInt(index.substring(2));

        settimana.get(giorno).setImpegno(impegno,fascia);
    }

    public Settimana clona(){
        Settimana clone = new Settimana();

        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 12; j++){
                String index = (String.valueOf(i) + "." + String.valueOf(j));
                clone.setImpegno(settimana.get(i).getImpegnoByFascia(j),index);
            }
        return clone;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        String toString = "";

        for(Giorno giorno : settimana){
            toString = toString.concat(giorno.toString() + "\n");
        }
        return toString;
    }
}
