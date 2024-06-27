package main.java.usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Test
	void testTiposDespesas() {
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		TipoDespesa teste0 = new TipoDespesa("Educação", "Curso de Idioma");
		TipoDespesa teste1 = new TipoDespesa("Educação", "Jardim da Infância");
		TipoDespesa teste2 = new TipoDespesa("Alimentação", "Supermercado");
		assertEquals(tiposDespesas.get(0), teste0);
		assertEquals(tiposDespesas.get(1), teste1);
		assertEquals(tiposDespesas.get(2), teste2);
	}
	
	@Test
	void testTiposReceitas() {
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		TipoReceita teste0 = new TipoReceita("Salário", "Principal");
		TipoReceita teste1 = new TipoReceita("Salário", "Bico");
		TipoReceita teste2 = new TipoReceita("Investimento", "Popança");
		assertEquals(tiposReceitas.get(0), teste0);
		assertEquals(tiposReceitas.get(1), teste1);
		assertEquals(tiposReceitas.get(2), teste2);
	}
	
	@Test
	void testLancamentos() throws ParseException {
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		lancamentos = leitor.leLancamentos("lancamentos.csv");
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yy");
		Lancamento teste0 = new Lancamento(1, formatoData.parse("01/05/24"), "Pai", false, "Principal", 10000, "Salário do papai");
		Lancamento teste1 = new Lancamento(2, formatoData.parse("02/05/24"), "Pai", false, "Bico", 1000, "Conserto computador vizinha");
		Lancamento teste2 = new Lancamento(3, formatoData.parse("02/05/24"), "Pai", true,  "Cinema", 50, "Barbie");
		assertEquals(lancamentos.get(0), teste0);
		assertEquals(lancamentos.get(1), teste1);
		assertEquals(lancamentos.get(2), teste2);
	}
}
