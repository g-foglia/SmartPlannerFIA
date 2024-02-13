package results;

import fitness.FitnessFunction;
import individuals.Settimana;
import metaheuristics.GeneticAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Results {
    private final GeneticAlgorithm geneticAlgorithm;
    private final Stack<ArrayList<Settimana>> generazioni;
    private final ArrayList<Settimana> miglioreGenerazione;
    private final List<String> log;

    public Results(GeneticAlgorithm geneticAlgorithm, Stack<ArrayList<Settimana>> generazioni, ArrayList<Settimana> miglioreGenerazione, List<String> log) {
        this.geneticAlgorithm = geneticAlgorithm;
        this.generazioni = generazioni;
        this.miglioreGenerazione = miglioreGenerazione;
        this.log = log;
    }

    public GeneticAlgorithm getGeneticAlgorithm() {
        return geneticAlgorithm;
    }

    public Stack<ArrayList<Settimana>> getGenerazioni() {
        return generazioni;
    }

    public ArrayList<Settimana> getMiglioreGenerazione() {
        return miglioreGenerazione;
    }

    public List<String> getLog() {
        return log;
    }

    public int getNumeroIterazioni(){
        return generazioni.size();
    }

    public Settimana getMigliorIndividuo(){
        return miglioreGenerazione.stream().min(new Comparator<Settimana>() {
            @Override
            public int compare(Settimana settimana1, Settimana settimana2) {
                return (settimana1.getFitness() - settimana2.getFitness());
            }
        }).get();
    }
}
