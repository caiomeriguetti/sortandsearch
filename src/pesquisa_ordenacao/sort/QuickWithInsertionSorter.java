package pesquisa_ordenacao.sort;

import pesquisa_ordenacao.Comparator;

public class QuickWithInsertionSorter extends QuickSorter {
	
	public QuickWithInsertionSorter(Comparator comp) {
		super(comp);
	}
	
	protected void ordena(int esq, int dir) {
		if (Math.abs(dir - esq) <= 25) {
			Sorter s = new InsertionSorter(this.comp);
			s.setVetor(this.vetor);
			s.sort(esq, dir);
		} else {
			super.ordena(esq, dir);
		}
	}
}
