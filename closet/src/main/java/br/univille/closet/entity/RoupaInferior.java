package br.univille.closet.entity;

public class RoupaInferior {
    private int id;
    private String tipo;
    private String cor;
    private String tamanho;
    private String tecido;

    // Construtor
    public RoupaInferior(int id, String tipo, String cor, String tamanho, String tecido) {
        this.id = id;
        this.tipo = tipo;
        this.cor = cor;
        this.tamanho = tamanho;
        this.tecido = tecido;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }
}