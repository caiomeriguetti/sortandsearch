package pesquisa_ordenacao;

import java.util.ArrayList;
import java.util.List;

import pesquisa_ordenacao.sort.HeapSorter;
import pesquisa_ordenacao.sort.QuickSorter;
import pesquisa_ordenacao.sort.QuickWithInsertionSorter;
import pesquisa_ordenacao.sort.ShellSorter;
import pesquisa_ordenacao.sort.Sorter;

public class AppOrdenacao {

	public static void main(String[] args) {
		
		List<String> arquivos = new ArrayList<>();
		
		arquivos.add("registros10000alea.txt");
		arquivos.add("registros10000inv.txt");
		arquivos.add("registros10000ord.txt");
		
		arquivos.add("registros1000alea.txt");
		arquivos.add("registros1000inv.txt");
		arquivos.add("registros1000ord.txt");
		
		arquivos.add("registros50000alea.txt");
		arquivos.add("registros50000inv.txt");
		arquivos.add("registros50000ord.txt");
		
		arquivos.add("registros5000alea.txt");
		arquivos.add("registros5000inv.txt");
		arquivos.add("registros5000ord.txt");

		arquivos.add("registros500alea.txt");
		arquivos.add("registros500inv.txt");
		arquivos.add("registros500ord.txt");
		
		int n = 5;
		
		Comparator sortComparator = new MunicipioNomeComparator();
		
		for (String arquivo : arquivos) {
			String arquivoPath = "arquivos/"+arquivo;
			String arquivoProcessadosPath = "arquivos/processados/"+arquivo;
			
			TimeCounter t = TimeCounter.startTime();
			String processedFilename = arquivoProcessadosPath+"_processado_ShellSorter";
			for (int i = 1; i <= n; i++) {
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoPath);
				
				Sorter s = new ShellSorter(sortComparator);
				s.setVetor(items);
				s.sort();
				
				CSVUtils.saveItems(processedFilename, s.getVetor());
			}
			
			t.end();
			StringWriter.write(processedFilename + "_time", Double.toString(t.getTdelta()/n));
			
			
			
			t = TimeCounter.startTime();
			processedFilename = arquivoProcessadosPath+"_processado_QuickSorter";
			for (int i = 1; i <= n; i++) {
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoPath);
				
				Sorter s = new QuickSorter(sortComparator);
				s.setVetor(items);
				s.sort();
				
				CSVUtils.saveItems(processedFilename, s.getVetor());
			}
			t.end();
			StringWriter.write(processedFilename + "_time", Double.toString(t.getTdelta()/n));
			
//			t = TimeCounter.startTime();
//			processedFilename = arquivoPath+"_processado_InsertionSorter";
//			for (int i = 1; i <= n; i++) {
//				CSVParser p = new CSVParser();
//				List<Item> items = p.load(arquivoPath);
//				
//				Sorter s = new InsertionSorter(sortComparator);
//				s.setVetor(items);
//				s.sort();
//				
//				CSVUtils.saveItems(arquivoPath+"_processado_InsertionSorter", s.getVetor());
//			}
//			t.end();
//			StringWriter.write(processedFilename + "_time", Double.toString(t.getTdelta()/n));
			
			
			t = TimeCounter.startTime();
			processedFilename = arquivoProcessadosPath+"_processado_QuickWithInsertionSorter";
			for (int i = 1; i <= n; i++) {
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoPath);
				
				Sorter s = new QuickWithInsertionSorter(sortComparator);
				s.setVetor(items);
				s.sort();
				
				CSVUtils.saveItems(processedFilename, s.getVetor());
			}
			t.end();
			StringWriter.write(processedFilename + "_time", Double.toString(t.getTdelta()/n));
			
			
			
			t = TimeCounter.startTime();
			processedFilename = arquivoProcessadosPath+"_processado_HeapSorter";
			for (int i = 1; i <= n; i++) {
				CSVParser p = new CSVParser();
				List<Item> items = p.load(arquivoPath);
				
				Sorter s = new HeapSorter(sortComparator);
				s.setVetor(items);
				s.sort();
				
				CSVUtils.saveItems(processedFilename, s.getVetor());
			}
			t.end();
			StringWriter.write(processedFilename + "_time", Double.toString(t.getTdelta()/n));
			
		}
		
	}
	
}
