package main.java.usp.mac321.ep2;

public interface EscritaReceita {
	public boolean criaTipoReceita(TipoReceita tipoReceita);
	public boolean removeTipoReceita(TipoReceita tipoReceita);
	public boolean escreveTipoReceita(String arquivo);
}