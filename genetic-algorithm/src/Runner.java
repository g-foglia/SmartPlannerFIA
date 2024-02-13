import fitness.FitnessFunction;
import individuals.Settimana;
import initializers.RandomInitializer;
import metaheuristics.GeneticAlgorithm;
import operators.crossover.CrossoverAlgorithm;
import operators.crossover.CrossoverOperator;
import operators.mutation.ScrambleMutation;
import operators.mutation.SwapMutation;
import operators.selection.RouletteWheelSelection;
import operators.selection.TruncationSelection;
import results.Results;

public class Runner {
    public static void main(String[] args){

        final int numeroIndividui = 5;
        final double probabilitaMutazione = 1;
        final int maxIterations = 1000;
        final int maxIterazionsNoImprovements = 0;

        FitnessFunction fitnessFunction = new FitnessFunction();
        RandomInitializer initializer = new RandomInitializer(numeroIndividui);

        //RouletteWheelSelection selectionOperator = new RouletteWheelSelection();
        TruncationSelection selectionOperator = new TruncationSelection();

        CrossoverOperator crossoverOperator = new CrossoverAlgorithm();

        ScrambleMutation mutationOperator = new ScrambleMutation();
        //SwapMutation mutationOperator = new SwapMutation();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(fitnessFunction, initializer,
                selectionOperator, crossoverOperator, mutationOperator, probabilitaMutazione, maxIterations, maxIterazionsNoImprovements);
        Results results = geneticAlgorithm.run();
        Settimana miglioreIndividuo = results.getMigliorIndividuo();
        results.getLog().forEach(System.out::println);
        System.out.println("Ricerca terminata in " + results.getNumeroIterazioni() +"/" +
                geneticAlgorithm.getMaxIterations() + " iterazioni");
        System.out.println("Miglior individuo: ");
        System.out.println(miglioreIndividuo);
        System.out.println("Fitness = " + miglioreIndividuo.getFitness());
    }
}
