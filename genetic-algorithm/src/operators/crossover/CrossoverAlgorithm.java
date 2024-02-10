package operators.crossover;

import individuals.Impegno;
import individuals.Settimana;

import java.util.*;

public class CrossoverAlgorithm extends CrossoverOperator{
    public CrossoverAlgorithm() {
    }

    public ArrayList<Settimana> crossover(ArrayList<Settimana> popolazione, Random r){
        ArrayList<Settimana> nuovaPopolazione = (ArrayList<Settimana>) popolazione.clone();
        nuovaPopolazione.clear();

        ArrayList<Coppia> coppie = generaCoppieCasuali(popolazione);
        for(Coppia coppia : coppie){
            Set<Impegno> impegniInseriti = new HashSet<>();
            Settimana successore = new Settimana();
            Set<Impegno> impegniTotali = new HashSet<>();
            for(int i = 0; i < 7; i++)
                impegniTotali.addAll(coppia.genitore1.getGiorno(i).getImpegni());

            int rigaCrossover = r.nextInt(12);
            //copia nel successore la disposizione di eventi del genitore1 fino alla riga scelta casualmente
            for(int i = 0; i < rigaCrossover; i++){
                for(int j = 0; j < 7; j++){
                    String index = (String.valueOf(j) + "." + String.valueOf(i));
                    Impegno impegno = coppia.genitore1.getGiorno(j).getImpegnoByFascia(i);
                    if(!impegniInseriti.contains(impegno) && impegno != null) {
                        successore.setImpegno(impegno, index);
                        impegniInseriti.add(impegno);
                    }
                }
            }

            //copia nel successore la disposizione di eventi del genitore2 a partire dalla riga scelta casualmente
            for(int i = rigaCrossover; i < 12; i++){
                for(int j = 0; j < 7; j++){
                    String index = (String.valueOf(j) + "." + String.valueOf(i));
                    Impegno impegno = coppia.genitore2.getGiorno(j).getImpegnoByFascia(i);
                    if(!impegniInseriti.contains(impegno) && impegno != null) {
                        successore.setImpegno(impegno, index);
                        impegniInseriti.add(impegno);
                    }
                }
            }

            if(!impegniInseriti.equals(impegniTotali)){
                for(Impegno impegno : impegniTotali){
                    boolean continua = true;
                    while(continua){
                        int giorno = r.nextInt(7);
                        int fascia = r.nextInt(12);
                        if(successore.getGiorno(giorno).getImpegnoByFascia(fascia) == null){
                            successore.setImpegno(impegno,(String.valueOf(giorno) + "." + String.valueOf(fascia)));
                            continua = false;
                        }
                    }
                }
            }
            nuovaPopolazione.add(successore.clona());
        }
        return nuovaPopolazione;
    }


    private class Coppia {
        protected final Settimana genitore1;
        protected final Settimana genitore2;

        public Coppia(Settimana genitore1, Settimana genitore2) {
            this.genitore1 = genitore1;
            this.genitore2 = genitore2;
        }
    }

    private ArrayList<Coppia> generaCoppieCasuali(ArrayList<Settimana> popolazione){
        ArrayList<Coppia> coppie = new ArrayList<>();

        if(popolazione.size() < 2){
            Settimana settimana = popolazione.get(0).clona();
            Coppia coppia = new Coppia(settimana,settimana);
            coppie.add(coppia);
        }
        else{
            Collections.shuffle(popolazione);
            if(popolazione.size() % 2 != 0)
                popolazione.remove(popolazione.size() - 1);

            for(int i = 0; i < popolazione.size(); i += 2){
                Settimana genitore1 = popolazione.get(i);
                Settimana genitore2 = popolazione.get(i + 1);
                Coppia coppia = new Coppia(genitore1,genitore2);
                coppie.add(coppia);
            }
        }
        return coppie;
    }
}
