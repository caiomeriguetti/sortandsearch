package pesquisa_ordenacao.sort;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;

public class ShellSorter extends Sorter {
	
	public ShellSorter(Comparator comp) {
		this.comp = comp;
	}
	
	public void sort (){
		
		 int i, j, h;
		 Item temp;
		
		 h = 1;
		 do {
		     h = 3 * h + 1;
		 } while (h < this.nElem);
		 do {
		     h = h / 3;
		     for (i = h; i < this.nElem; i++) {
		         temp = this.vetor[i];
		         j = i;
		         while (getComparator().gt(this.vetor[j - h], temp)) {
		             this.vetor[j] = this.vetor[j - h];
		             j -= h;
		             if (j < h)
		                 break;
		         }
		         this.vetor[j] = temp;
		     }
		 } while (h != 1);
	}
}
