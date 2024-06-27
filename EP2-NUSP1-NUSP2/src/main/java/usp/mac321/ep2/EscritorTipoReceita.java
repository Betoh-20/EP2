package main.java.usp.mac321.ep2;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorTipoReceita implements EscritaReceita {
    private List<TipoReceita> tiposReceitas;
    
    public EscritorTipoReceita(List<TipoReceita> tiposReceitas) {
        this.tiposReceitas = tiposReceitas;
    }
    
    @Override
    public boolean criaTipoReceita(TipoReceita tipoReceita) {
        if (duplicado(tipoReceita))
            return false;
        
        tiposReceitas.add(tipoReceita);
        return true;
    }
    
    @Override
    public boolean removeTipoReceita(TipoReceita tipoReceita) {
        for (TipoReceita t : tiposReceitas) {
            if (tipoReceita.toString().equals(t.toString())) {
                tiposReceitas.remove(t);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean escreveTipoReceita(String arquivo) {
        try (PrintWriter writer = new PrintWriter(arquivo, "UTF-8")) {
            writer.println("Categoria, Subcategoria");
            for (TipoReceita t : tiposReceitas)
                writer.println(t.getCategoria() + "," + t.getSubcategoria());
            return true;
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv não encontrado");
            return false;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
            System.err.println("Formato inválido");
            return false;
        }
    }
    
    public boolean duplicado(TipoReceita tipoReceita) {
        for (TipoReceita t : tiposReceitas) {
            if (tipoReceita.toString().equals(t.toString()))
                return true;
        }
        return false;
    }
}
