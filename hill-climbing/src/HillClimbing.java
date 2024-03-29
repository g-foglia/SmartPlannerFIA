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
        int i = 0;
        boolean continua = true;

        long inizio = System.currentTimeMillis();
        while(continua){
            i++;

            //creo un vicino andando a scambiare di posizione in maniera casuale due impegni
            Settimana vicino = attuale.clona();
            String index1 = getRandomIndex();
            String index2 = getRandomIndex();
            vicino.swap(index1,index2);

            if(attuale.getTotalScore() >= vicino.getTotalScore()) {
                attuale = vicino.clona();
            }
            //per altre 1000 volte cerca di trovare un vicino migliore, altrimenti ferma la ricerca
            else{
                int j;
                for(j = 0; j < 1000; j++){
                    Settimana vicino2 = attuale.clona();
                    index1 = getRandomIndex();
                    index2 = getRandomIndex();
                    vicino2.swap(index1,index2);
                    if(attuale.getTotalScore() >= vicino.getTotalScore()) {
                        attuale = vicino.clona();
                        break;
                    }
                }
                if(j == 1000)
                    continua = false;
            }
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
        impegni.add(new Impegno("pingpong",3));
        impegni.add(new Impegno("videogiochi",1));
        impegni.add(new Impegno("lavoro",4));
        impegni.add(new Impegno("fitness",2));
        impegni.add(new Impegno("calcio",1));
        impegni.add(new Impegno("riposo",1));
        impegni.add(new Impegno("videocall",5));
        impegni.add(new Impegno("danza",4));
        impegni.add(new Impegno("palestra",2));
        impegni.add(new Impegno("yoga",5));
        impegni.add(new Impegno("biliardo",5));
        impegni.add(new Impegno("pallavolo",1));
        impegni.add(new Impegno("bar",3));
        impegni.add(new Impegno("shopping",1));
        impegni.add(new Impegno("mare",4));
        impegni.add(new Impegno("youtube",2));
        impegni.add(new Impegno("tiktok",1));
        impegni.add(new Impegno("instagram",1));
        impegni.add(new Impegno("x",5));
        impegni.add(new Impegno("threads",4));
        impegni.add(new Impegno("corso di aggiornamento",2));
        impegni.add(new Impegno("pilates",5));
        impegni.add(new Impegno("pittura",5));
        impegni.add(new Impegno("pattinaggio",1));
        impegni.add(new Impegno("baseball",1));
        impegni.add(new Impegno("football",2));
        impegni.add(new Impegno("rugby",1));
        impegni.add(new Impegno("musica",2));

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