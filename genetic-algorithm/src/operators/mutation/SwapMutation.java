package operators.mutation;

import individuals.Impegno;
import individuals.Settimana;
import java.util.Random;

public class SwapMutation {
    public SwapMutation() {
    }

    public Settimana mutation(Settimana settimana){
        String index1 = getRandomIndex();
        String index2 = getRandomIndex();
        while(index1.equals(index2))
            index2 = getRandomIndex();

        int giorno1 = Integer.parseInt(index1.substring(0,1));
        int giorno2 = Integer.parseInt(index2.substring(0,1));
        int fascia1 = Integer.parseInt(index1.substring(2));
        int fascia2 = Integer.parseInt(index2.substring(2));

        Impegno impegno1 = settimana.getGiorno(giorno1).getImpegnoByFascia(fascia1);
        Impegno impegno2 = settimana.getGiorno(giorno2).getImpegnoByFascia(fascia2);

        Settimana mutato = settimana.clona();
        mutato.getGiorno(giorno1).setImpegno(impegno2,fascia1);
        mutato.getGiorno(giorno2).setImpegno(impegno1,fascia2);

        return mutato;
    }

    private String getRandomIndex(){
        Random r = new Random();
        return (String.valueOf(r.nextInt(7)) + "." + String.valueOf(r.nextInt(12)));
    }
}
