package br.univille.closet.entity;

public class Acessorios {
    private int id;
    private String tipo;
    private String cor;
    private String material;

    // Construtor
    public Acessorios(int id, String tipo, String cor, String material) {
        this.id = id;
        this.tipo = tipo;
        this.cor = cor;
        this.material = material;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}