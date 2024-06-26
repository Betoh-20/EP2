package main.java.usp.mac321.ep2;

import java.util.Date;

public class Lancamento {
    private int id;
    private Date data;
    private String responsavel;
    private boolean RD;
    private String subcategoria;
    private String descricao;
    private double valor;

    public Lancamento (int id, Date data, String responsavel, boolean RD, String subcategoria, double valor, String descricao) {
        this.id = id;
        this.data = data;
        this.responsavel = responsavel;
        this.RD = RD;
        this.subcategoria = subcategoria;
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public Date getData() {
        return this.data;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public boolean isRD() {
        return this.RD;
    }

    public String getSubcategoria() {
        return this.subcategoria;
    }

    public double getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
