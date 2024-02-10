package initializers;
import individuals.Impegno;
import individuals.Settimana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomInitializer {
    private final int numeroDiIndividui;
    private final ArrayList<Impegno> impegni = getImpegni();

    public RandomInitializer(int numeroDiIndividui) {
        this.numeroDiIndividui = numeroDiIndividui;
    }

    public ArrayList<Settimana> initialize(){
        ArrayList<Settimana> popolazione = new ArrayList<>();

        //per ogni individuo aggiunge tutti gli impegni in modo casuale
        for(int i = 0; i < numeroDiIndividui; i++){
            Collections.shuffle(impegni);
            Settimana settimana = new Settimana();
            boolean continua;

            for(Impegno impegno : impegni){
                continua = true;
                while(continua) {
                    String index = getRandomIndex();
                    int giorno = Integer.parseInt(index.substring(0, 1));
                    int fascia = Integer.parseInt(index.substring(2));

                    if (settimana.getGiorno(giorno).getImpegnoByFascia(fascia) == null) {
                        settimana.setImpegno(impegno, index);
                        continua = false;
                    }
                }
            }
            popolazione.add(settimana);
        }
        return popolazione;
    }

    private String getRandomIndex(){
        Random r = new Random();
        return (String.valueOf(r.nextInt(7)) + "." + String.valueOf(r.nextInt(12)));
    }

    private ArrayList<Impegno> getImpegni(){
        ArrayList<Impegno> impegni = new ArrayList<>();

        impegni.add(new Impegno("pingpong",60,3));
        impegni.add(new Impegno("videogiochi",60,1));
        impegni.add(new Impegno("lavoro",60,4));
        impegni.add(new Impegno("fitness",60,2));
        impegni.add(new Impegno("calcio",60,1));
        impegni.add(new Impegno("riposo",60,1));
        impegni.add(new Impegno("videocall",60,5));
        impegni.add(new Impegno("danza",60,4));
        impegni.add(new Impegno("palestra",60,2));
        impegni.add(new Impegno("yoga",60,6));
        impegni.add(new Impegno("biliardo",60,5));
        impegni.add(new Impegno("pallavolo",60,1));
        impegni.add(new Impegno("bar",60,3));
        impegni.add(new Impegno("shopping",60,1));
        impegni.add(new Impegno("mare",60,4));
        impegni.add(new Impegno("youtube",60,2));
        impegni.add(new Impegno("tiktok",60,1));
        impegni.add(new Impegno("instagram",60,1));
        impegni.add(new Impegno("x",60,5));
        impegni.add(new Impegno("threads",60,4));
        impegni.add(new Impegno("corso di aggiornamento",60,2));
        impegni.add(new Impegno("pilates",60,6));
        impegni.add(new Impegno("pittura",60,5));
        impegni.add(new Impegno("pattinaggio",60,1));
        impegni.add(new Impegno("baseball",60,1));
        impegni.add(new Impegno("football",60,2));
        impegni.add(new Impegno("rugby",60,1));
        impegni.add(new Impegno("musica",60,2));

        return  impegni;
    }
}
