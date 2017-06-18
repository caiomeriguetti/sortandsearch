package pesquisa_ordenacao.sort;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;

public class HeapSorter extends Sorter {
	
	public HeapSorter(Comparator comp) {
		this.comp = comp;
	}
	
	public void sort() {
	    int dir = nElem - 1;
	    int esq = (dir - 1) / 2;
	    Item temp;

	    while (esq >= 0) {
	        refazHeap(esq, this.nElem - 1);
	        esq--;
	    }
	    while (dir > 0) {
	        temp = this.vetor[0];
	        this.vetor[0] = this.vetor[dir];
	        this.vetor[dir] = temp;
	        dir--;
	        refazHeap(0, dir);
	    }
	}
	private void refazHeap(int esq, int dir) {
	    int i = esq;
	    int mF = 2 * i + 1; // maior filho
	    Item raiz = this.vetor[i];
	    boolean heap = false;

	    while ((mF <= dir) && (!heap)) {
	        if (mF < dir)
	        	//if (this.vetor[mF].getChave() < this.vetor[mF+1].getChave())
	            if (getComparator().lt(this.vetor[mF], this.vetor[mF + 1]))
	                mF++;
	        //if (raiz.getChave() < this.vetor[mF].getChave()) {
	        if (getComparator().lt(raiz, this.vetor[mF])) {
	                this.vetor[i] = this.vetor[mF];
	            i = mF;
	            mF = 2 * i + 1;
	        } else
	            heap = true;
	    }
	    this.vetor[i] = raiz;
	}
}
