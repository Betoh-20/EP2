package main.java.usp.mac321.ep2;

import java.util.Objects;

public class TipoReceita {
    private String categoria;
    private String subcategoria;

    public TipoReceita(String categoria, String subcategorias) {
        this.categoria = categoria;
        this.subcategoria = subcategorias;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getSubcategoria() {
        return this.subcategoria;
    }
    
    @Override
    public boolean equals(Object object) {
    	if(this == object)
    		return true;
    	if(getClass() != object.getClass())
    		return false;
    	TipoReceita compare = (TipoReceita) object;
    	return Objects.equals(categoria, compare.getCategoria()) &&
    			Objects.equals(subcategoria, compare.getSubcategoria());
    }
}
