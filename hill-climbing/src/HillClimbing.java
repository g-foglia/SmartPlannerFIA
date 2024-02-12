import entities.Impegno;
import entities.Settimana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HillClimbing {

    //un vicino rappresenta uno scheduling in cui due impegni
    //sono stati spostati di posizione
    public static void main(String[] args){
        Settimana attuale = createSettimana();
        Settimana vicino = attuale.clona();
        int i = 0;

        long inizio = System.currentTimeMillis();
        while(attuale.getTotalScore() >= vicino.getTotalScore()){
            i++;
            //creo un vicino andando a scambiare di posizione in maniera casuale due impegni
            String index1 = getRandomIndex();
            String index2 = getRandomIndex();
            vicino.swap(index1,index2);

            if(attuale.getTotalScore() >= vicino.getTotalScore())
                attuale = vicino.clona();
        }
        long fine = System.currentTimeMillis();

        System.out.println("Numero iterazioni: " + i + "\n");
        System.out.println("Tempo di esecuzione dell'algoritmo in millisecondi: " + (fine-inizio) + "\n");
        System.out.println("Punteggio finale migliore: " + attuale.getTotalScore() + "\n");
        System.out.println("Scheduling migliore:\n" + attuale);
    }

    private static Settimana createSettimana(){
        Settimana settimana = new Settimana();
        ArrayList<Impegno> impegni = new ArrayList<>();

        //la somma totale delle priorità è 76 e l'ottimo globale ha punteggio 0
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

        Collections.shuffle(impegni);
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
        return settimana;
    }

    private static String getRandomIndex(){
        Random r = new Random();
        return (String.valueOf(r.nextInt(7)) + "." + String.valueOf(r.nextInt(12)));
    }
}