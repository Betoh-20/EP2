package main.java.usp.mac321.ep2;

public interface EscritaUsuario {
	public boolean criaUsuario(Usuario usuario);
	public boolean removeUsuario(Usuario usuario);
	public boolean escreveUsuarios(String arquivo);
}
