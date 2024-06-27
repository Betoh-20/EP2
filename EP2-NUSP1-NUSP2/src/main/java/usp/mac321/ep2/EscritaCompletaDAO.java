package main.java.usp.mac321.ep2;

import java.util.List;

public interface EscritaCompletaDAO {
	public boolean criaTipoDespesa(TipoDespesa tipoDespesa);
    public boolean criaTipoReceita(TipoReceita tipoReceita);
    public boolean criaUsuario(Usuario usuario);
    public boolean criaLancamento(Lancamento lancamento);

    public boolean removeTipoDespesa(TipoDespesa tipoDespesa);
    public boolean removeTipoReceita(TipoReceita tipoReceita);
    public boolean removeUsuario(Usuario usuario);
    public boolean removeLancamento(Lancamento lancamento);

    public boolean escreveTiposDespesas(List<TipoDespesa> tiposDespesas, String arquivo);
    public boolean escreveTiposReceitas(List<TipoReceita> tiposReceitas, String arquivo);
    public boolean escreveUsuarios(List<Usuario> usuarios, String arquivo);
    public boolean escreveLancamentos(List<Lancamento> lancamentos, String arquivo);
}
