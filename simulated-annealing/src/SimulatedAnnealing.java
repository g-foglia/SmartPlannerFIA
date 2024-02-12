import entities.Impegno;
import entities.Settimana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SimulatedAnnealing {
    private static double temperature = 1000;
    private static double coolingFactor = 0.99996;  //a queste condizioni l'esecuzione avviene in circa 3 secondi

    public static void main(String[] args){
        Settimana attuale = createSettimana();
        Settimana best = attuale.clona();
        int i = 0;

        long inizio = System.currentTimeMillis();

        for(double t = temperature; t > 1; t *= coolingFactor, i++){
            //creo un vicino andando a scambiare di posizione in maniera casuale due impegni
            Settimana vicino = attuale.clona();

            String index1 = getRandomIndex();
            String index2 = getRandomIndex();
            vicino.swap(index1,index2);

            //ottengo i due valori di score
            int score1 = attuale.getTotalScore();
            int score2 = vicino.getTotalScore();

            //calcolo la probabilità di accettare la nuova soluzione e in caso la accetto
            if(Math.random() < probability(score1, score2, t))
                attuale = vicino.clona();

            if(attuale.getTotalScore() < best.getTotalScore())
                best = attuale.clona();
        }

        long fine = System.currentTimeMillis();

        System.out.println("Numero iterazioni: " + i + "\n");
        System.out.println("Tempo di esecuzione dell'algoritmo in millisecondi: " + (fine-inizio) + "\n");
        System.out.println("Punteggio finale migliore: " + best.getTotalScore() + "\n");
        System.out.println("Scheduling migliore:\n" + best);
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

    //restituisce la probabilità di accettare il secondo parametro
    public static double probability(int score1, int score2, double temp) {
        int delta = score1 - score2;
        //se lo score del secondo scheduling è migliore (quindi minore) di quello del primo, accetto il secondo
        if (delta > 0) return 1;

        return Math.exp(((double)(score2-score1)) / temp);
    }
}
