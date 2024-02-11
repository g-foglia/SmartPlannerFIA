package fitness;

import individuals.Settimana;

public class FitnessFunction {
    public FitnessFunction() {
    }

    public void evaluate(Settimana settimana){
        int fitness = getFitness(settimana);
        settimana.setFitness(fitness);
    }

    private int getFitness(Settimana settimana){
        int totale = 0;

        for(int i = 0; i < 7; i++){
            int totg = settimana.getGiorno(i).getTotalScore();
            int bonusg = settimana.getGiorno(i).getTotalBen();
            int malusg = settimana.getGiorno(i).getTotalMalus();

            totale += (totg - bonusg + malusg);
        }
        return totale;
    }
}
