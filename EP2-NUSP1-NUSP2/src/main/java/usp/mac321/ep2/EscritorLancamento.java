package main.java.usp.mac321.ep2;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorLancamento implements EscritaLancamento {
    private List<Lancamento> lancamentos;
    
    public EscritorLancamento(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
    @Override
    public boolean criaLancamento(Lancamento lancamento) {
        if (duplicado(lancamento))
            return false;
        
        lancamentos.add(lancamento);
        return true;
    }
    
    @Override
    public boolean removeLancamento(Lancamento lancamento) {
        for (Lancamento l : lancamentos) {
            if (lancamento.toString().equals(l.toString())) {
                lancamentos.remove(l);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean escreveLancamento(String arquivo) {
        try (PrintWriter writer = new PrintWriter(arquivo, "UTF-8")) {
            writer.println("ID, Data, Responsável, Despesa?, SubCategoria, Valor, Descrição");
            for (Lancamento l : lancamentos)
                writer.println(l.getId() + ", " + l.getData() + ", " + l.getResponsavel() + ", " + l.isRD()
            	+ ", " + l.getSubcategoria() + ", " + l.getValor() + ", " + l.getDescricao());
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
    
    public boolean duplicado(Lancamento lancamento) {
        for (Lancamento l : lancamentos) {
            if (lancamento.toString().equals(l.toString()))
                return true;
        }
        return false;
    }
}
