package operators.crossover;

import individuals.Settimana;

import java.util.ArrayList;
import java.util.Random;

public abstract class CrossoverOperator {
    public abstract ArrayList<Settimana> crossover(ArrayList<Settimana> popolazione, Random r);
}
