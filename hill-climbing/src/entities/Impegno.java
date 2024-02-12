package entities;

public class Impegno {

    private String nomeImpegno;
    private int prioritaImpegno;



//metodo costruttore
    public Impegno(String nomeImpegno,  int prioritaImpegno) {
        this.nomeImpegno = nomeImpegno;
        this.prioritaImpegno = prioritaImpegno;
    }

//metodo per settare il codice dell'impegno


//metodo per restituire il nome dell'impegno

    public String getNomeImpegno() {
        return nomeImpegno;
    }
    //metodo per settare il nome dell'impegno
    public void setNomeImpegno(String nomeImpegno) {
        this.nomeImpegno = nomeImpegno;
    }

    //metodo per restituire la priorità  dell'impegno
    public int getPrioritaImpegno() {
        return prioritaImpegno;
    }
    //metodo per settare la priorità dell'impegno
    public void setPrioritaImpegno(int prioritaImpegno) {
        this.prioritaImpegno = prioritaImpegno;
    }
    public Impegno() {
    }

    @Override
    public String toString() {
        return nomeImpegno;
    }
}