package pesquisa_ordenacao.sort;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;

public class InsertionSorter extends Sorter {
	
	public InsertionSorter(Comparator comp) {
		this.comp = comp;
	}
	
	public void sort() {
		this.sort(0, vetor.length - 1);
	}
	
	public void sort(int begin, int end) {
		this.nElem = end - begin;
	    int i, j;
	    Item temp;
	    for (i = begin + 1; i < end+1; i++) {
	        temp = this.vetor[i];
	        j = i - 1;
	        while ((j >= 0) &&
	            //(this.vetor[j].getChave() > temp.getChave())) {
	        	(getComparator().gt(this.vetor[j], temp))) {
	            this.vetor[j + 1] = this.vetor[j];
	            j--;
	        }
	        this.vetor[j + 1] = temp;
	    }
	}
}
