package operators.selection;

import individuals.Settimana;

import java.util.ArrayList;
import java.util.Random;

public class RouletteWheelSelection{
    public RouletteWheelSelection(){
    }

    class Elemento{
        protected final Settimana individuo;
        protected final double posizioneiniziale;
        protected final double size;

        public Elemento(Settimana individuo, double posizioneiniziale, double size) {
            this.individuo = individuo;
            this.posizioneiniziale = posizioneiniziale;
            this.size = size;
        }
    }

    public ArrayList<Settimana> selection(ArrayList<Settimana> popolazione, Random r){
        int totalFitness = popolazione.stream()
                .map(Settimana::getFitness)
                .reduce(Integer::sum)
                .orElse(0);
        if(totalFitness == 0)
            return popolazione;

        ArrayList<Elemento> rouletteWheel = new ArrayList<>();
        double posizioneCorrente = 0.0;
        for(Settimana settimana : popolazione){
            double fitnessRelativa = (double) settimana.getFitness() / totalFitness;
            Elemento elemento = new Elemento(settimana,posizioneCorrente,fitnessRelativa);
            rouletteWheel.add(elemento);
            posizioneCorrente += fitnessRelativa;
        }

        ArrayList<Settimana> nuovaPopolazione = (ArrayList<Settimana>) popolazione.clone();
        nuovaPopolazione.clear();
        for(int i = 0; i < rouletteWheel.size(); i++){
            double puntatore = r.nextDouble();
            for(Elemento elemento : rouletteWheel){
                if(elemento.posizioneiniziale <= puntatore && puntatore < elemento.posizioneiniziale + elemento.size){
                    Settimana vincitore = elemento.individuo;
                    nuovaPopolazione.add(vincitore.clona());
                    break;
                }
            }
        }
        return nuovaPopolazione;
    }
}
