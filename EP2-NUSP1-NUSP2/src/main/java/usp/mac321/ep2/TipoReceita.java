package main.java.usp.mac321.ep2;

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
}
