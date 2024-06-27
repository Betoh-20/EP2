package main.java.usp.mac321.ep2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeitorFinancasPessoais implements LeitorFinancasPessoaisDAO {
    List<Usuario> usuarios = new LinkedList<>();
    List<TipoDespesa> tiposDespesas = new LinkedList<>();
    List<TipoReceita> tiposReceitas = new LinkedList<>();
    List<Lancamento> lancamentos = new LinkedList<>();

    private static String inputFile
            = System.getProperty("user.dir") + "\\csv\\";

    @Override
    public List<Usuario> leUsuarios(String nomeArquivoUsuarios) {
        String arquivoUsuarios = inputFile + nomeArquivoUsuarios;
        System.out.println(arquivoUsuarios);
        Set<String> apelidos = new HashSet<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoUsuarios))) {
            String linha = leitor.readLine();

            while (linha != null) {
            	String[] dados = linha.split(",");
                String apelido = dados[0];
                try {
                    if(!apelidos.add(apelido))
                        throw new LeitorException("Dois usuários possuem o mesmo apelido\nApelido: " + apelido);
                } catch (LeitorException e) {
                    System.err.println(e);
                }
                String nome = dados[1];
                usuarios.add(new Usuario(apelido, nome));
                linha = leitor.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        }
        return usuarios;
    }

    @Override
    public List<TipoDespesa> leTiposDespesas(String nomeArquivoTiposDespesas) {
        String arquivoDespesas = inputFile + nomeArquivoTiposDespesas;

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoDespesas))) {
        	 String linha = leitor.readLine();

            while (linha != null) {
            	String[] dados = linha.split(",");
                String categoria = dados[0];
                String subcategoria = dados[1];
                tiposDespesas.add(new TipoDespesa(categoria, subcategoria));
                linha = leitor.readLine();
            }
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        }

        return tiposDespesas;
    }

    @Override
    public List<TipoReceita> leTiposReceitas(String nomeArquivoTiposReceitas) {
        String arquivoReceitas = inputFile + nomeArquivoTiposReceitas;

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoReceitas))) {
        	 String linha = leitor.readLine();

            while (linha != null) {
            	String[] dados = linha.split(",");
                String categoria = dados[0];
                String subcategoria = dados[1];
                tiposReceitas.add(new TipoReceita(categoria, subcategoria));
                linha = leitor.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        }

        return tiposReceitas;
    }

    @Override
    public List<Lancamento> leLancamentos(String nomeArquivoLancamentos) {
        String arquivoLancamentos = inputFile + nomeArquivoLancamentos;
        Set<Integer> IDs = new HashSet<>();
        DateFormat formatoData = DateFormat.getDateInstance();

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoLancamentos))) {
        	String linha = leitor.readLine();

            while (linha != null) {
            	String[] dados = linha.split(",");

                int ID = Integer.parseInt(dados[0]);
                Date data = formatoData.parse(dados[1]);
                String responsavel = dados[2];
                boolean RD = dados[3].equals("TRUE");
                String subcategoria = dados[4];
                double valor = Double.parseDouble(dados[5]);
                String descricao = dados[6];

                if(!IDs.add(ID))
                    throw new LeitorException("Dois lançamentos possuem o mesmo ID\nID: " + ID);
                
                for(Usuario u : usuarios) {
	                if(!u.getApelido().equals(responsavel))
	                    throw new LeitorException("Lançamento associado a usuario inexistente\nID: " + ID);
                }

                if(RD && !isSubDespesa(subcategoria))
                    throw new LeitorException("Despesa subcategorizada como Receita\nID: " + ID);
                else if (!RD && !isSubReceita(subcategoria))
                    throw new LeitorException("Receita subcategorizada como Despesa\nID: " + ID);
                if(valor < 0)
                    throw new LeitorException("Formato de valor inválido\nID: " + ID);

                lancamentos.add(new Lancamento(ID, data, responsavel, RD, subcategoria, valor, descricao));
                linha = leitor.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        } catch (ParseException e) {
            System.err.println(e);
            System.err.println("Formato de data inválido");
        } catch(LeitorException e) {
            System.err.println(e);
        }

        return lancamentos;
    }
    
    private boolean isSubDespesa(String compare) {
    	for(TipoDespesa t: tiposDespesas) {
    		if(t.getSubcategoria().equals(compare))
    			return true;
    	}
    	return false;
    }
    
    private boolean isSubReceita(String compare) {
    	for(TipoReceita t : tiposReceitas) {
    		if(t.getSubcategoria().equals(compare))
    			return true;
    	}
    	return false;
    }
}