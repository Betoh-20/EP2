package main.java.usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestaEscritaPlanilhas {
	private EscritorUsuario escritorUsuario;
	private EscritorTipoDespesa escritorTipoDespesa;
	private EscritorTipoReceita escritorTipoReceita;
	private EscritorLancamento escritorLancamento;
	private LeitorFinancasPessoaisDAO leitor;
	
	private static String inputFile
    	= System.getProperty("user.dir") + "\\csv\\";

	
	@BeforeEach
	public void setup() {
		leitor = new LeitorFinancasPessoais();
	}
	
	@AfterEach
	public void tearDown() {
		leitor = null;
	}
	
	@Test
    public void testeEscritorUsuario(){
		String arquivo = inputFile + "usuariosSaida.csv";
		escritorUsuario = new EscritorUsuario(leitor.leUsuarios("usuarios.csv"));
		
		Usuario teste0 = new Usuario("Pai","Epaminondas Encerrabodes Eleutério");
		Usuario teste1 = new Usuario("Zezinho", "José Josimarson Eleutério");
        Usuario teste2 = new Usuario("Carlinhos", "Carlos Eleutério");
        escritorUsuario.criaUsuario(teste2);
        escritorUsuario.escreveUsuarios(arquivo);
        
        List<Usuario> saida = leitor.leUsuarios(arquivo);
        
        assertTrue(saida.get(0).toString().equals(teste0.toString()));
        assertTrue(saida.get(1).toString().equals(teste1.toString()));
        assertTrue(saida.get(2).toString().equals(teste2.toString()));
    }
	
	@Test
    public void testeEscritorTipoDespesa(){
		String arquivo = inputFile + "tiposDespesasSaida.csv";
		escritorTipoDespesa = new EscritorTipoDespesa(leitor.leTiposDespesas("tiposDespesas.csv"));
		
		TipoDespesa teste0 = new TipoDespesa("Pai","Epaminondas Encerrabodes Eleutério");
		TipoDespesa teste1 = new TipoDespesa("Zezinho", "José Josimarson Eleutério");
        TipoDespesa teste2 = new TipoDespesa("Carlinhos", "Carlos Eleutério");
        escritorUsuario.criaUsuario(teste2);
        escritorUsuario.escreveUsuarios(arquivo);
        
        List<Usuario> saida = leitor.leUsuarios(arquivo);
        
        assertTrue(saida.get(0).toString().equals(teste0.toString()));
        assertTrue(saida.get(1).toString().equals(teste1.toString()));
        assertTrue(saida.get(2).toString().equals(teste2.toString()));
    }
}
