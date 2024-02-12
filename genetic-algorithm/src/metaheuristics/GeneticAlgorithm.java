package metaheuristics;

import fitness.FitnessFunction;
import individuals.Settimana;
import initializers.RandomInitializer;
import operators.crossover.CrossoverOperator;
import operators.mutation.ScrambleMutation;
import operators.mutation.SwapMutation;
import operators.selection.RouletteWheelSelection;
import operators.selection.TruncationSelection;
import results.Results;

import java.util.*;

public class GeneticAlgorithm {
    private final static int scrambleSize = 5;  //numero di geni che saranno permutati nella scramble mutation
    private final static int truncationSize = 5;  //size della nuova popolazione dopo truncation selection
    private final FitnessFunction fitnessFunction;
    private final RandomInitializer initializer;
    private final TruncationSelection selectionOperator;
    //private final RouletteWheelSelection selectionOperator;
    private final CrossoverOperator crossoverOperator;
    //private final ScrambleMutation mutationOperator;
    private final SwapMutation mutationOperator;
    private final double probabilitaMutazione;
    private final int maxIterations;
    private final int maxIterationsNoImprovements;

    public GeneticAlgorithm(FitnessFunction fitnessFunction, RandomInitializer randomInitializer,
    TruncationSelection /*RouletteWheelSelection*/ selectionOperator, CrossoverOperator crossoverOperator,
    SwapMutation        /*ScrambleMutation*/ mutationOperator, double probabilitaMutazione,
                            int maxIterations, int maxIterationsNoImprovements){
        this.fitnessFunction = fitnessFunction;
        this.initializer = randomInitializer;
        this.selectionOperator = selectionOperator;
        this.crossoverOperator = crossoverOperator;
        this.mutationOperator = mutationOperator;
        if(0.0 <= probabilitaMutazione && probabilitaMutazione <= 1.0)
            this.probabilitaMutazione = probabilitaMutazione;
        else
            this.probabilitaMutazione = 0.1;
        this.maxIterations = Math.max(maxIterations,1);
        this.maxIterationsNoImprovements = Math.max(maxIterationsNoImprovements,0);
    }

    public Results run(){
        Random r = new Random();
        List<String> log = new ArrayList<>();
        Stack<ArrayList<Settimana>> generazioni = new Stack<>();

        generazioni.push(initializer.initialize());
        ArrayList<Settimana> primaGenerazione = generazioni.peek();
        primaGenerazione.forEach(fitnessFunction::evaluate);

        double totFitness = 0;
        for(Settimana settimana : primaGenerazione)
            totFitness += settimana.getFitness();

        log.add("Gen 1) " + (totFitness /primaGenerazione.size()) + " (CurrentAvg)");
        ArrayList<Settimana> miglioreGenerazione = primaGenerazione;

        int iterations = 1;
        int iterationsNoImprovements = 0;
        boolean maxNoImprovementsExceeded = false;
        do{
            StringBuilder logEntry = new StringBuilder();
            ArrayList<Settimana> generazioneCorrente = generazioni.peek();

            //ArrayList<Settimana> matingPool = selectionOperator.selection(generazioneCorrente, r);
            ArrayList<Settimana> matingPool = selectionOperator.selection(generazioneCorrente, truncationSize);

            ArrayList<Settimana> offsprings = crossoverOperator.crossover(matingPool, r);

            ArrayList<Settimana> nuovaGenerazione = new ArrayList<>();
            if(r.nextDouble() <= probabilitaMutazione){
                for(Settimana settimana : offsprings)
                    //nuovaGenerazione.add(mutationOperator.mutation(settimana, scrambleSize));
                    nuovaGenerazione.add(mutationOperator.mutation(settimana));
            }
            else nuovaGenerazione = offsprings;

            nuovaGenerazione.forEach(fitnessFunction::evaluate);
            generazioni.push(nuovaGenerazione);
            iterations++;
            logEntry.append("Gen ").append(iterations).append(") ");

            totFitness = 0;
            for(Settimana settimana : miglioreGenerazione)
                totFitness += settimana.getFitness();
            double bestFitnessMedio = (totFitness / miglioreGenerazione.size());

            totFitness = 0;
            for(Settimana settimana : nuovaGenerazione)
                totFitness += settimana.getFitness();
            double nuovoFitnessMedio = (totFitness / nuovaGenerazione.size());

            logEntry.append(nuovoFitnessMedio).append(" vs ").append(bestFitnessMedio).append(" (NewAvg vs BestAvg)");

            if(nuovoFitnessMedio < bestFitnessMedio){
                miglioreGenerazione = nuovaGenerazione;
                iterationsNoImprovements = 0;
                logEntry.append(" ==> Improvement");
            }
            else{
                iterationsNoImprovements++;
                maxNoImprovementsExceeded = (0 < maxIterationsNoImprovements && maxIterationsNoImprovements < iterationsNoImprovements);
                if(maxNoImprovementsExceeded)
                    logEntry.append(" ==> Early Stop");
            }
            log.add(logEntry.toString());
        }while (iterations < maxIterations && !maxNoImprovementsExceeded);
        return new Results(this,generazioni,miglioreGenerazione,log);
    }

    public double getProbabilitaMutazione() {
        return probabilitaMutazione;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public int getMaxIterationsNoImprovements() {
        return maxIterationsNoImprovements;
    }
}
