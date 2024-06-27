package main.java.usp.mac321.ep2;

public interface EscritaLancamento {
	public boolean criaLancamento(Lancamento lancamento);
	public boolean removeLancamento(Lancamento lancamento);
	public boolean escreveLancamento(String arquivo);
}