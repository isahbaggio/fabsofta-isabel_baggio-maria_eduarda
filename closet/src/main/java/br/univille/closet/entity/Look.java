package br.univille.closet.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Look{
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private RoupaInferior roupaInferior;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private RoupaSuperior roupaSuperior;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Acessorios acessorio;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Sapato sapato;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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