package operators.mutation;

import individuals.Impegno;
import individuals.Settimana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ScrambleMutation {
    public ScrambleMutation() {
    }

    public Settimana mutation(Settimana settimana, int size){
        ArrayList<String> indexList = new ArrayList<>();
        ArrayList<Impegno> subSet = new ArrayList<>();

        //crea una lista di size indici in modo casuale, senza ripetizioni
        for(int i = 0; i < size; i++){
            String index = getRandomIndex();
            if(!indexList.contains(index)) indexList.add(index);
            else i--;
        }

        //estrae gli impegni corrispondenti a quegli indici
        for(String index : indexList){
            int giorno = Integer.parseInt(index.substring(0,1));
            int fascia = Integer.parseInt(index.substring(2));

            subSet.add(settimana.getGiorno(giorno).getImpegnoByFascia(fascia));
        }
        Collections.shuffle(subSet);

        //dopo aver cambiato l'ordine degli impegni li riposizione nell'individuo
        Settimana mutato = settimana.clona();
        for(int i = 0; i < size; i++){
            mutato.setImpegno(subSet.get(i),indexList.get(i));
        }
        return mutato;
    }

    private String getRandomIndex(){
        Random r = new Random();
        return (String.valueOf(r.nextInt(7)) + "." + String.valueOf(r.nextInt(12)));
    }
}
