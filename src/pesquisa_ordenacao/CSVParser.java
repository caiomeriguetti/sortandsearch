package pesquisa_ordenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	
	public List<Item> load(String file) {
		String csvFile = file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        List<Item> items = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                String[] dados = line.split(cvsSplitBy);
                String nome = dados[0];
                String cpf = dados[1];
                String cidade = dados[2];
                
                Item item = new Item();
                item.setNome(nome);
                item.setCidade(cidade);
                item.setCpf(cpf);
                items.add(item);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return items;
	}
	
	public List<String> loadPesquisa(String file) {
		String csvFile = file;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        List<String> items = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                String[] dados = line.split(cvsSplitBy);
                items.add(dados[0]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return items;
	}
	
}
