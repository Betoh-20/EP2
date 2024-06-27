package main.java.usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
	
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestaLeitura {

	
	List<Usuario>      usuarios;
	List<TipoDespesa>  tiposDespesas;
	List<TipoReceita>  tiposReceitas;
	List<Lancamento>   lancamentos;
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
	public void testTiposDespesas(){
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		assertEquals(6, tiposDespesas.size());
	}
	
	@Test
	public void testTiposReceitas(){
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		assertEquals(4, tiposReceitas.size());
	}
	
	@Test
	public void testUsuarios(){
		usuarios = leitor.leUsuarios("usuarios.csv");
		assertEquals(2, usuarios.size());
	}
	
	@Test
	public void testLancamentosOK(){
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		lancamentos = leitor.leLancamentos("lancamentos.csv");
		assertEquals(8, lancamentos.size());
	}

	@Test
	public void testLancamentoUsuarioDesconhecido(){
		usuarios = leitor.leUsuarios("usuarios.csv");
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		assertThrows (
			LeitorException.class,
			() -> lancamentos = leitor.leLancamentos("lancamentosSemResponsa.csv")
		);
	}
	
	@Test
	public void testLancamentoDespesaDesconhecida(){
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		assertThrows (
			LeitorException.class,
			() -> lancamentos = leitor.leLancamentos("lancamentosDespesaErrada.csv")
		);
}
	@Test
	public void testLancamentoReceiraDesconhecida(){
		tiposDespesas = leitor.leTiposDespesas("tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("tiposReceitas.csv");
		assertThrows (
			LeitorException.class,
			() -> lancamentos = leitor.leLancamentos("lancamentosReceitaErrada.csv")
		);
	}
}
