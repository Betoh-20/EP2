package main.java.usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestaLeitorFinancasPessoais {
	List<Usuario> usuarios;
	List<TipoDespesa> tiposDespesas;
	List<TipoReceita> tiposReceitas;
	List<Lancamento> lancamentos;
	LeitorFinancasPessoaisDAO leitor;

	@BeforeEach
	void setUp() throws Exception {
		leitor = new LeitorFinancasPessoais();
	}

	@AfterEach
	void tearDown() throws Exception {
		leitor = null;
	}

	@Test
	void testUsuarios() {
		usuarios = leitor.leUsuarios("usuarios.csv");
		Usuario teste0 = new Usuario("Pai","Epaminondas Encerrabodes Eleutério");
		Usuario teste1 = new Usuario("Zezinho", "José Josimarson Eleutério");
		assertEquals(usuarios.get(0), teste0);
		assertEquals(usuarios.get(1), teste1);
	}
	

}
