package pesquisa_ordenacao;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	private int length = 0;
	private Item first;
	private Item last;
	private Comparator s;
	
	public LinkedList(Comparator s) {
		this.s = s;
	}
	
	public Item getLast() {
		return last;
	}

	public int getLength() {
		return length;
	}

	public void append(Item val) {
		
		if (first == null) {
			first = last = val;
		} else {
			last.setNext(val);
			last = val;
		}
		
		length ++;
	}
	
	public Item[] getItem(String key) {
		List<Item> all = new ArrayList<>();
		if (first != null) {
			Item current = first;
			while(current != null) {
				if (s.eqByValue(key, current)) {
					all.add(current);
				}
				
				current = current.getNext();
			}
		}
		
		return all.toArray(new Item[all.size()]);
	}

	public String toString() {
		Item currentNode = first;
		String buffer = "";
		while(currentNode != null){
			buffer += String.valueOf(currentNode.toString()) + " ";
			currentNode = currentNode.getNext();
		}
		
		return buffer;
	}
}