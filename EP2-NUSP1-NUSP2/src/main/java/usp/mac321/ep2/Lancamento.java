package main.java.usp.mac321.ep2;

import java.util.Date;
import java.util.Objects;

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
    
    @Override
    public boolean equals(Object object) {
    	if(this == object)
    		return true;
    	if (getClass() != object.getClass())
    		return false;
    	Lancamento compare = (Lancamento) object;
    	return Objects.equals(id, compare.getId()) &&
    			Objects.equals(data, compare.getData()) &&
    			Objects.equals(responsavel, compare.getResponsavel()) &&
    			Objects.equals(RD, compare.isRD()) &&
    			Objects.equals(subcategoria, compare.getSubcategoria()) &&
    			Objects.equals(valor, compare.getValor()) &&
    			Objects.equals(descricao, compare.getDescricao());
    }
}
