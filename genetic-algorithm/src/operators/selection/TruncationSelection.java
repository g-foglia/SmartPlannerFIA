package operators.selection;

import individuals.Settimana;

import java.util.ArrayList;
import java.util.Comparator;

public class TruncationSelection{
    public TruncationSelection() {
    }

    public ArrayList<Settimana> selection(ArrayList<Settimana> popolazione, int size){
        ArrayList<Settimana> temp = (ArrayList<Settimana>) popolazione.clone();

        temp.sort(new Comparator<Settimana>() {
            @Override
            public int compare(Settimana settimana, Settimana settimana1) {
                return (settimana.getFitness() - settimana1.getFitness());
            }
        });

        ArrayList<Settimana> nuovaPopolazione = new ArrayList<>(temp.subList(0,size));
        return nuovaPopolazione;
    }
}
