package main.java.usp.mac321.ep2;

import java.util.Objects;

public class Usuario {
    private String apelido;
    private String nome;

    public Usuario(String apelido, String nome) {
        this.apelido = apelido;
        this.nome = nome;
    }

    public String getApelido() {
        return this.apelido;
    }

    public String getNome() {
        return this.nome;
    }
    
    @Override
    public boolean equals(Object object) {
    	if(this == object)
    		return true;
    	if(getClass() != object.getClass())
    		return false;
    	Usuario compare = (Usuario) object;
    	return Objects.equals(apelido, compare.getApelido()) &&
    			Objects.equals(nome, compare.getNome());
    }
}
