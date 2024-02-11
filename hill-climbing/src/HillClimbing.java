import entities.Impegno;
import entities.Settimana;

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
        //la somma totale delle priorità è 76 e l'ottimo globale ha punteggio 0
        settimana.setImpegno(new Impegno("pingpong",60,3),"0.0");
        settimana.setImpegno(new Impegno("videogiochi",60,1),"0.1");
        settimana.setImpegno(new Impegno("lavoro",60,4),"0.2");
        settimana.setImpegno(new Impegno("fitness",60,2),"0.3");
        settimana.setImpegno(new Impegno("calcio",60,1),"0.4");
        settimana.setImpegno(new Impegno("riposo",60,1),"0.5");
        settimana.setImpegno(new Impegno("videocall",60,5),"0.6");
        settimana.setImpegno(new Impegno("danza",60,4),"0.7");
        settimana.setImpegno(new Impegno("palestra",60,2),"0.8");
        settimana.setImpegno(new Impegno("yoga",60,6),"0.9");
        settimana.setImpegno(new Impegno("biliardo",60,5),"0.10");
        settimana.setImpegno(new Impegno("pallavolo",60,1),"0.11");
        settimana.setImpegno(new Impegno("bar",60,3),"1.0");
        settimana.setImpegno(new Impegno("shopping",60,1),"1.1");
        settimana.setImpegno(new Impegno("mare",60,4),"1.2");
        settimana.setImpegno(new Impegno("youtube",60,2),"1.3");
        settimana.setImpegno(new Impegno("tiktok",60,1),"1.4");
        settimana.setImpegno(new Impegno("instagram",60,1),"1.5");
        settimana.setImpegno(new Impegno("x",60,5),"1.6");
        settimana.setImpegno(new Impegno("threads",60,4),"1.7");
        settimana.setImpegno(new Impegno("corso di aggiornamento",60,2),"1.8");
        settimana.setImpegno(new Impegno("pilates",60,6),"1.9");
        settimana.setImpegno(new Impegno("pittura",60,5),"1.10");
        settimana.setImpegno(new Impegno("pattinaggio",60,1),"1.11");
        settimana.setImpegno(new Impegno("baseball",60,1),"2.0");
        settimana.setImpegno(new Impegno("football",60,2),"2.1");
        settimana.setImpegno(new Impegno("rugby",60,1),"2.2");
        settimana.setImpegno(new Impegno("musica",60,2),"2.3");

        return settimana;
    }

    private static String getRandomIndex(){
        Random r = new Random();
        return (String.valueOf(r.nextInt(7)) + "." + String.valueOf(r.nextInt(12)));
    }
}