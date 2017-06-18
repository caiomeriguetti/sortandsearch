package pesquisa_ordenacao.search;

import java.util.List;

import pesquisa_ordenacao.Item;
import pesquisa_ordenacao.LinkedList;
import pesquisa_ordenacao.Comparator;

public class HashSearcher {
	private LinkedList[] items;
	private int M;
	private Comparator comp;
	public HashSearcher(Comparator comp, int M) {
		this.M = M;
		items = new LinkedList[M];
		this.comp = comp;
	}
	
	public void load(List<Item> l) {
		for (Item item : l) {
			insert(item);
		}
	}
	
	public Item[] search(Object key) {
		
		int addr = Hashing((String)key);
		
		LinkedList l = items[addr];
		
		if (l != null) {
			return l.getItem((String)key);
		}
		
		return null;
	}
	
	public void insert(Item item) {
		Object key = comp.getKey(item);
		int addr = Hashing((String)key);
		
		if (items[addr] == null) {
			LinkedList l = new LinkedList(comp);
			items[addr] = l;
			l.append(item);
		} else {
			items[addr].append(item);
		}
	}

	public int Hashing(String chave) {
	    char carac;
	    int i, soma = 0;
	    for (i = 0; i < chave.length(); i++) {
	        carac = chave.charAt(i);
	        soma += Character.getNumericValue(carac);
	    }
	    return soma%M;
	}
}
