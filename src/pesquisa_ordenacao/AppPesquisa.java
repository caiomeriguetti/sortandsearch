package pesquisa_ordenacao;

import java.util.ArrayList;
import java.util.List;

import pesquisa_ordenacao.search.ABB;
import pesquisa_ordenacao.search.ArvoreAVL;
import pesquisa_ordenacao.search.BinarySearcher;
import pesquisa_ordenacao.search.HashSearcher;

public class AppPesquisa {
	public static void main(String[] args) {
		int n = 5;
		
		List<String> tamanhos = new ArrayList<>();
		tamanhos.add("500");
		tamanhos.add("1000");
		tamanhos.add("5000");
		tamanhos.add("10000");
		tamanhos.add("50000");
		
		CSVParser pPesquisa = new CSVParser();
		List<String> itemsPesquisa = pPesquisa.loadPesquisa("arquivos/pesquisa.txt");
		
		for (String tamanho : tamanhos) {

			String result_filename = "arquivos/processados/BinarySearcher_municipios_"+tamanho;
			TimeCounter c = TimeCounter.startTime();
			
			for (int i = 1; i <= n; i++) {
				String arquivoOrdenado = "arquivos/processados/registros"+tamanho+"alea.txt_processado_QuickSorter";
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoOrdenado);
				
				BinarySearcher b = new BinarySearcher(new MunicipioSearchComparator());
				b.load(items);
				String buffer = "";
				for (String itemPesquisa : itemsPesquisa) {
					Item found = null;
					buffer += "MUNICIPIO: " + itemPesquisa + "\n\n";
					int founds = 0;
					do {
						found = b.search(itemPesquisa);
						if (found != null) {
							buffer += ">> " +found.getNome() + "\n";
							b.remove(itemPesquisa);
							founds ++;
						}
						
					} while(found != null);
					
					if (founds == 0) {
						buffer += ">> MUNICIPIO INEXISTENTE\n\n";
					} else {
						buffer += "\n";
					}
					
				}
				
				StringWriter.write(result_filename, buffer);
			}
			
			c.end();
			StringWriter.write(result_filename + "_time", Double.toString(c.getTdelta()/n));
			
			result_filename = "arquivos/processados/ABB_municipios_"+tamanho;
			c = TimeCounter.startTime();
			
			for (int i = 1; i <= n; i++) {
				String arquivoOrdenado = "arquivos/processados/registros"+tamanho+"alea.txt_processado_QuickSorter";
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoOrdenado);
				
				Comparator s = new MunicipioSearchComparator();
				ABB b = new ABB(s);
				b.load(items);
				
				String buffer = "";
				for (String itemPesquisa : itemsPesquisa) {
					Item found = null;
					buffer += "MUNICIPIO: " + itemPesquisa + "\n\n";
					int founds = 0;
					do {
						
						found = b.remove(itemPesquisa);
						
						if (found != null) {
							buffer += ">> " +found.getNome() + "\n";
							founds ++;
						}
						
					} while(found != null);
					
					if (founds == 0) {
						buffer += ">> MUNICIPIO INEXISTENTE\n\n";
					} else {
						buffer += "\n";
					}
					
				}
				
				StringWriter.write(result_filename, buffer);
			}
			
			c.end();
			StringWriter.write(result_filename + "_time", Double.toString(c.getTdelta()/n));

			result_filename = "arquivos/processados/AVL_municipios_"+tamanho;
			c = TimeCounter.startTime();
			
			for (int i = 1; i <= n; i++) {
				String arquivoOrdenado = "arquivos/processados/registros"+tamanho+"alea.txt_processado_QuickSorter";
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoOrdenado);
				
				Comparator s = new MunicipioSearchComparator();
				ArvoreAVL b = new ArvoreAVL(s);
				b.load(items);
				
				String buffer = "";
				for (String itemPesquisa : itemsPesquisa) {
					Item found = null;
					buffer += "MUNICIPIO: " + itemPesquisa + "\n\n";
					int founds = 0;
					do {
						found = b.remove(itemPesquisa);
						if (found != null) {
							buffer += ">> " +found.getNome() + "\n";
							founds ++;
						}
						
					} while(found != null);
					
					if (founds == 0) {
						buffer += ">> MUNICIPIO INEXISTENTE\n\n";
					} else {
						buffer += "\n";
					}
					
				}
				
				StringWriter.write(result_filename, buffer);
			}
			
			c.end();
			StringWriter.write(result_filename + "_time", Double.toString(c.getTdelta()/n));
			
			result_filename = "arquivos/processados/Hash_municipios_"+tamanho;
			c = TimeCounter.startTime();
			
			for (int i = 1; i <= n; i++) {
				String arquivoOrdenado = "arquivos/processados/registros"+tamanho+"alea.txt_processado_QuickSorter";
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoOrdenado);
				
				Comparator s = new MunicipioSearchComparator();
				HashSearcher b = new HashSearcher(s, 2*Integer.parseInt(tamanho));
				b.load(items);
				
				String buffer = "";
				for (String itemPesquisa : itemsPesquisa) {
					buffer += "MUNICIPIO: " + itemPesquisa + "\n\n";
					Item[] founds = b.search(itemPesquisa);
					if (founds != null) {
						for (Item found : founds) {
							buffer += ">> " +found.getNome() + "\n";
						}
					}
					
					if (founds == null || founds.length == 0) {
						buffer += ">> MUNICIPIO INEXISTENTE\n\n";
					} else {
						buffer += "\n";
					}
					
				}
				
				StringWriter.write(result_filename, buffer);
			}
			
			c.end();
			StringWriter.write(result_filename + "_time", Double.toString(c.getTdelta()/n));
			
		}
		
		
	}
}
