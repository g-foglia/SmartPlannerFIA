package entities;

public class Impegno {
    private int codiceImpegno;
    private String nomeImpegno;
    private int durataImpegno;
    private int prioritaImpegno;



//metodo costruttore
    public Impegno(String nomeImpegno, int durataImpegno, int prioritaImpegno) {
        this.nomeImpegno = nomeImpegno;
        this.durataImpegno = durataImpegno;
        this.prioritaImpegno = prioritaImpegno;

    }
//metodo per restituire il codice dell'impegno
    public int getCodiceImpegno() {
        return codiceImpegno;
    }
//metodo per settare il codice dell'impegno

    public void setCodiceImpegno(int codiceImpegno) {
        this.codiceImpegno = codiceImpegno;
    }
//metodo per restituire il nome dell'impegno

    public String getNomeImpegno() {
        return nomeImpegno;
    }
    //metodo per settare il nome dell'impegno
    public void setNomeImpegno(String nomeImpegno) {
        this.nomeImpegno = nomeImpegno;
    }
    //metodo per restituire la durata dell'impegno
    public int getDurataImpegno() {
        return durataImpegno;
    }
    //metodo per settare la durata dell'impegno
    public void setDurataImpegno(int durataImpegno) {
        this.durataImpegno = durataImpegno;
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