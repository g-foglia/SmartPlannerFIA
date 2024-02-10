package individuals;

public class Impegno {
    private int codiceImpegno;
    private String nomeImpegno;
    private int durataImpegno;
    private int prioritaImpegno;

    public Impegno() {
    }

    public Impegno(String nomeImpegno, int durataImpegno, int prioritaImpegno) {
        this.nomeImpegno = nomeImpegno;
        this.durataImpegno = durataImpegno;
        this.prioritaImpegno = prioritaImpegno;
    }

    public int getCodiceImpegno() {
        return codiceImpegno;
    }

    public void setCodiceImpegno(int codiceImpegno) {
        this.codiceImpegno = codiceImpegno;
    }

    public String getNomeImpegno() {
        return nomeImpegno;
    }

    public void setNomeImpegno(String nomeImpegno) {
        this.nomeImpegno = nomeImpegno;
    }

    public int getDurataImpegno() {
        return durataImpegno;
    }

    public void setDurataImpegno(int durataImpegno) {
        this.durataImpegno = durataImpegno;
    }

    public int getPrioritaImpegno() {
        return prioritaImpegno;
    }

    public void setPrioritaImpegno(int prioritaImpegno) {
        this.prioritaImpegno = prioritaImpegno;
    }

    @Override
    public String toString() {
        return nomeImpegno;
    }
}
