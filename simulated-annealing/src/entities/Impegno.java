package entities;

public class Impegno {

    private String nomeImpegno;
    private int prioritaImpegno;

    public Impegno(){}

    public Impegno(String nomeImpegno, int prioritaImpegno){

        this.nomeImpegno = nomeImpegno;
        this.prioritaImpegno = prioritaImpegno;

    }

    public void setNomeImpegno(String nomeImpegno){
        this.nomeImpegno = nomeImpegno;
    }

    public void setPrioritaImpegno(int prioritaImpegno){
        this.prioritaImpegno = prioritaImpegno;
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
