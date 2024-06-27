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
		Usuario teste1 = new Usuario("Pai","Epaminondas Encerrabodes Eleutério");
		Usuario teste2 = new Usuario("Zezinho", "José Josimarson Eleutério");
		assertEquals(usuarios.get(1), teste1);
		assertEquals(usuarios.get(2), teste2);
	}
	
	@Test
	void testTiposDespesas() {
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		TipoDespesa teste1 = new TipoDespesa("Educação", "Curso de Idioma");
		TipoDespesa teste2 = new TipoDespesa("Educação", "Jardim da Infância");
		TipoDespesa teste3 = new TipoDespesa("Alimentação", "Supermercado");
		assertEquals(tiposDespesas.get(1), teste1);
		assertEquals(tiposDespesas.get(2), teste2);
		assertEquals(tiposDespesas.get(3), teste3);
	}
	
	@Test
	void testTiposReceitas() {
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		TipoReceita teste1 = new TipoReceita("Salário", "Principal");
		TipoReceita teste2 = new TipoReceita("Salário", "Bico");
		TipoReceita teste3 = new TipoReceita("Investimento", "Popança");
		assertEquals(tiposReceitas.get(1), teste1);
		assertEquals(tiposReceitas.get(2), teste2);
		assertEquals(tiposReceitas.get(3), teste3);
	}
	
	@Test
	void testLancamentos() {
		
	}
}
