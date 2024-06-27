package main.java.usp.mac321.ep2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Leitor implements LeitorFinancasPessoaisDAO {
    List<Usuario> usuarios = new LinkedList<>();
    List<TipoDespesa> tiposDespesas = new LinkedList<>();
    List<TipoReceita> tiposReceitas = new LinkedList<>();
    List<Lancamento> lancamentos = new LinkedList<>();

    private static String inputFile
            = System.getProperty("user.dir") + "/csv/";

    @Override
    public List<Usuario> leUsuarios(String nomeArquivoUsuarios) {
        inputFile += nomeArquivoUsuarios;
        Set<String> apelidos = new HashSet<>();

        try {
            FileReader fileReader = new FileReader(inputFile);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] linha;

            while ((linha = csvReader.readNext()) != null) {
                linha = csvReader.readNext();
                String apelido = linha[0];
                try {
                    if(!apelidos.add(apelido))
                        throw new LeitorException("Dois usuários possuem o mesmo apelido\nApelido: " + apelido);
                } catch (LeitorException e) {
                    System.err.println(e);
                }
                String nome = linha[1];
                usuarios.add(new Usuario(apelido, nome));
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        } catch (CsvValidationException e) {
            System.err.println(e);
            System.err.println("Entrada inválida");
        }

        return usuarios;
    }

    @Override
    public List<TipoDespesa> leTiposDespesas(String nomeArquivoTiposDespesas) {
        inputFile += nomeArquivoTiposDespesas;

        try {
            FileReader fileReader = new FileReader(inputFile);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] linha = csvReader.readNext();

            while (linha != null) {
                linha = csvReader.readNext();
                String categoria = linha[0];
                String subcategoria = linha[1];
                tiposDespesas.add(new TipoDespesa(categoria, subcategoria));
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        } catch (CsvValidationException e) {
            System.err.println(e);
            System.err.println("Entrada inválida");
        }

        return tiposDespesas;
    }

    @Override
    public List<TipoReceita> leTiposReceitas(String nomeArquivoTiposReceitas) {
        inputFile += nomeArquivoTiposReceitas;

        try {
            FileReader fileReader = new FileReader(inputFile);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] line = csvReader.readNext();

            while (line != null) {
                line = csvReader.readNext();
                String categoria = line[0];
                String subcategoria = line[1];
                tiposReceitas.add(new TipoReceita(categoria, subcategoria));
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        } catch (CsvValidationException e) {
            System.err.println(e);
            System.err.println("Entrada inválida");
        }

        return tiposReceitas;
    }

    @Override
    public List<Lancamento> leLancamentos(String nomeArquivoLancamentos) {
        inputFile += nomeArquivoLancamentos;
        Set<Integer> IDs = new HashSet<>();
        DateFormat formatoData = DateFormat.getDateInstance();

        try {
            FileReader fileReader = new FileReader(inputFile);
            CSVReader csvReader = new CSVReader(fileReader);
            String[] line = csvReader.readNext();

            while (line != null) {
                line = csvReader.readNext();

                int ID = Integer.parseInt(line[0]);
                Date data = formatoData.parse(line[1]);
                String responsavel = line[2];
                boolean RD = line[3].equals("TRUE");
                String subcategoria = line[4];
                double valor = Double.parseDouble(line[5]);
                String descricao = line[6];

                if(!IDs.add(ID))
                    throw new LeitorException("Dois lançamentos possuem o mesmo ID\nID: " + ID);
                if(!usuarios.contains(responsavel))
                    throw new LeitorException("Lançamento associado a usuario inexistente\nID: " + ID);
                if(RD && !tiposDespesas.contains(subcategoria))
                    throw new LeitorException("Despesa categorizada como Receita\nID: " + ID);
                else if (!RD && !tiposReceitas.contains(subcategoria))
                    throw new LeitorException("Receita categorizada como Despesa\nID: " + ID);
                if(valor < 0)
                    throw new LeitorException("Formato de valor inválido\nID: " + ID);

                lancamentos.add(new Lancamento(ID, data, responsavel, RD, subcategoria, valor, descricao));
            }
            csvReader.close();
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.err.println("Documento .csv vão encontrado");
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Falha de entrada/saída");
        } catch (CsvValidationException e) {
            System.err.println(e);
            System.err.println("Entrada inválida");
        } catch (ParseException e) {
            System.err.println(e);
            System.err.println("Formato de data inválido");
        } catch(LeitorException e) {
            System.err.println(e);
        }

        return lancamentos;
    }
}