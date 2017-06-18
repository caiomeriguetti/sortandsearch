package pesquisa_ordenacao.search;

import java.util.List;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;
import pesquisa_ordenacao.sort.InsertionSorter;
import pesquisa_ordenacao.sort.Sorter;

public class BinarySearcher {
	
	protected int nElem;
	protected Item[] vetor;
	private Comparator comp;
	
	public BinarySearcher(Comparator comp) {
		this.comp = comp;
	}
	
	public Item search(Object key) {
		int k = pesqBinaria(key);
		
		if (k >= 0) {
			return vetor[k];
		}
		
		return null;
	}
	
	public int pesqBinaria(Object chave) {
	    int meio, esq, dir;
	    esq = 0;
	    dir = this.nElem - 1;
	    while (esq <= dir) {
	        meio = (esq + dir) / 2;
	        //if (chave == this.vetor[meio].getChave()) {
	        if (comp.eqByValue(chave, this.vetor[meio])) {
	            return meio;
	        } else {
	            //if (chave < this.vetor[meio].getChave())
	        	if (comp.ltByValue(chave, this.vetor[meio]))
	                dir = meio - 1;
	            else
	                esq = meio + 1;
	        }
	    }
	    
	    return -1;
	    
	}
	
	public void load(List<Item> l) {
		this.nElem = 0;
		this.vetor = new Item[l.size()];
		for (Item item : l) {
			insere(item, false);
		}
		reSort();
	}

	public boolean insere(Item elem) {
		return insere(elem, true);
	}
	
	private void reSort() {
		Sorter s = new InsertionSorter(this.comp);
        s.setVetor(vetor);
        s.sort(0, this.nElem -1);
	}
	
	public boolean insere(Item elem, boolean reSort) {
	    if (this.nElem == this.vetor.length)
	        return false;
	    else {
	        this.vetor[this.nElem++] = elem;
	        
	        if (reSort) {
		        this.reSort();
	        }
	    }
	    return true;
	}
	
	public boolean remove(Object chave) {
	    int i, pos;
	    if (this.nElem == 0)
	        return false;
	    else {
	        pos = pesqBinaria(chave);
	        if (pos >= 0) {
	            for (i = pos + 1; i < this.nElem; i++)
	                this.vetor[i - 1] = this.vetor[i];
	            this.nElem--;
	            return true;
	        } else
	            return false;
	    }
	}
}
