package main.java.usp.mac321.ep2;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EscritorUsuario implements EscritaUsuario {
	private List<Usuario> usuarios;
	
	public EscritorUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public boolean criaUsuario(Usuario usuario) {
		if(duplicado(usuario))
			return false;
		
		usuarios.add(usuario);
		return true;
	}
	
	@Override
	public boolean removeUsuario(Usuario usuario) {
		for(Usuario u : usuarios) {
			if(usuario.toString().equals(u.toString())) {
				usuarios.remove(u);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean escreveUsuarios(String arquivo) {
		try (PrintWriter writer = new PrintWriter(arquivo, "UTF-8")) {
            writer.println("Apelido, Nome");
            for (Usuario u : usuarios)
                writer.println(u.getApelido() + "," + u.getNome());
            return true;
        } catch (FileNotFoundException e) {
			System.err.println(e);
			System.err.println("Documento .csv vão encontrado");
			return false;
		} catch (UnsupportedEncodingException e) {
			System.err.println(e);
			System.err.println("Formato inválido");
			return false;
		}
	}
	
	public boolean duplicado(Usuario usuario) {
		for(Usuario u : usuarios) {
			if(usuario.toString().equals(u.toString()))
				return true;
		}
		return false;
	}
}
