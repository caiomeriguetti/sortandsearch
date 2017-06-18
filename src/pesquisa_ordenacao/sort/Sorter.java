package pesquisa_ordenacao.sort;

import java.util.List;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;
import pesquisa_ordenacao.MunicipioNomeComparator;

public class Sorter {
	protected int nElem;
	protected Item[] vetor;
	protected Comparator comp;
	protected Comparator getComparator() {
		return comp;
	}
	
	public Item[] getVetor() {
		return vetor;
	}

	public void setVetor(List<Item> x) {
		Item[] v = new Item[x.size()];
		this.setVetor(x.toArray(v));
		
	}
	
	public void setVetor(Item[] v) {
		this.vetor = v;
		this.nElem = vetor.length;
	}
	
	public void sort() {
		
	}
	
	public void sort(int begin, int end) {
		
	}
}
