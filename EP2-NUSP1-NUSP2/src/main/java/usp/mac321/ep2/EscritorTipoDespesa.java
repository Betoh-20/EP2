package main.java.usp.mac321.ep2;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorTipoDespesa implements EscritaDespesa {
    private List<TipoDespesa> tiposDespesas;
    
    public EscritorTipoDespesa(List<TipoDespesa> tiposDespesas) {
        this.tiposDespesas = tiposDespesas;
    }
    
    @Override
    public boolean criaTipoDespesa(TipoDespesa tipoDespesa) {
        if (duplicado(tipoDespesa))
            return false;
        
        tiposDespesas.add(tipoDespesa);
        return true;
    }
    
    @Override
    public boolean removeTipoDespesa(TipoDespesa tipoDespesa) {
        for (TipoDespesa t : tiposDespesas) {
            if (tipoDespesa.toString().equals(t.toString())) {
                tiposDespesas.remove(t);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean escreveTipoDespesa(String arquivo) {
        try (PrintWriter writer = new PrintWriter(arquivo, "UTF-8")) {
            writer.println("Categoria, Subcategoria");
            for (TipoDespesa t : tiposDespesas)
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
    
    public boolean duplicado(TipoDespesa tipoDespesa) {
        for (TipoDespesa t : tiposDespesas) {
            if (tipoDespesa.toString().equals(t.toString()))
                return true;
        }
        return false;
    }
}

