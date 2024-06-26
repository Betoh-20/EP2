package usp.mac321.ep2;

public class TipoDespesa {
    private String categoria;
    private String subcategoria;

    public TipoDespesa(String categoria, String subcategorias) {
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
