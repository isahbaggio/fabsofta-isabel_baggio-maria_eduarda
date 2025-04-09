package br.univille.closet.entity;

public class Look{
    private RoupaInferior roupaInferior;
    private RoupaSuperior roupaSuperior;
    private Acessorios acessorio;
    private Sapato sapato;

    public Look(RoupaInferior roupaInferior, RoupaSuperior roupaSuperior, Acessorios acessorio, Sapato sapato) {
        this.roupaInferior = roupaInferior;
        this.roupaSuperior = roupaSuperior;
        this.acessorio = acessorio;
        this.sapato = sapato;
    }

    public RoupaInferior getRoupaInferior() {
        return roupaInferior;
    }

    public void setRoupaInferior(RoupaInferior roupaInferior) {
        this.roupaInferior = roupaInferior;
    }

    public RoupaSuperior getRoupaSuperior() {
        return roupaSuperior;
    }

    public void setRoupaSuperior(RoupaSuperior roupaSuperior) {
        this.roupaSuperior = roupaSuperior;
    }

    public Acessorios getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorios acessorio) {
        this.acessorio = acessorio;
    }

    public Sapato getSapato() {
        return sapato;
    }

    public void setSapato(Sapato sapato) {
        this.sapato = sapato;
    }
}