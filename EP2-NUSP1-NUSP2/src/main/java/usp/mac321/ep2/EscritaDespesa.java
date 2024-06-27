package main.java.usp.mac321.ep2;

public interface EscritaDespesa {
	public boolean criaTipoDespesa(TipoDespesa tipoDespesa);
	public boolean removeTipoDespesa(TipoDespesa tipoDespesa);
	public boolean escreveTipoDespesa(String arquivo);
}
