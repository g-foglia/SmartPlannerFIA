package entities;

public class Impegno {

    private int codiceImpegno;
    private String nomeImpegno;
    private int durataImpegno;
    private int prioritaImpegno;


    public Impegno(String nomeImpegno, int durataImpegno, int prioritaImpegno){

        this.nomeImpegno = nomeImpegno;
        this.durataImpegno = durataImpegno;
        this.prioritaImpegno = prioritaImpegno;

    }

    public void setCodiceImpegno(int codiceImpegno){
        this.codiceImpegno = codiceImpegno;
    }

    public void setDurataImpegno(int durataImpegno){
        this.durataImpegno = durataImpegno;
    }

    public void setNomeImpegno(String nomeImpegno){
        this.nomeImpegno = nomeImpegno;
    }

    public void setPrioritaImpegno(int prioritaImpegno){
        this.prioritaImpegno = prioritaImpegno;
    }

    public int getCodiceImpegno(){
        return codiceImpegno;
    }

    public int getDurataImpegno(){
        return durataImpegno;
    }

    public String getNomeImpegno(){
        return nomeImpegno;
    }

    public int getPrioritaImpegno(){
        return prioritaImpegno;
    }

    @Override
    public  String toString(){
        return nomeImpegno;
    }

}
