package pesquisa_ordenacao.sort;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;

public class QuickSorter extends Sorter {
	
	public QuickSorter(Comparator comp) {
		this.comp = comp;
	}
	
	public void sort() {
	    ordena(0, this.nElem - 1);
	}
	
	protected void ordena(int esq, int dir) {
	    int i = esq, j = dir;
	    Item pivo;
	    Item temp;

	    pivo = this.vetor[(i + j) / 2];
	    do {
	        //while (this.vetor[i].getChave() < pivo)
	    	while (getComparator().lt(this.vetor[i], pivo))
	            i++;
	        //while (this.vetor[j].getChave() > pivo)
	    	while (getComparator().gt(this.vetor[j], pivo))
	            j--;
	        if (i <= j) {
	            temp = this.vetor[i];
	            this.vetor[i] = this.vetor[j];
	            this.vetor[j] = temp;
	            i++;
	            j--;
	        }
	    } while (i <= j);
	    if (esq < j)
	        ordena(esq, j);
	    if (dir > i)
	        ordena(i, dir);
	}
}
