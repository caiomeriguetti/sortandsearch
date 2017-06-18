package pesquisa_ordenacao;

public interface Comparator {
	
public boolean gt(Item item, Item item2);

	public Object getKey(Item item);

	public boolean lt(Item item, Item item2);
	
	public boolean eq(Item item, Item item2);
	
	public boolean lte(Item item, Item item2);
	
	public boolean gte(Item item, Item item2);
	
	public boolean gtByValue(Object value, Item item2);
	
	public boolean ltByValue(Object value, Item item2);
	
	public boolean eqByValue(Object value, Item item2);
	
	public boolean lteByValue(Object value, Item item2);
	
	public boolean gteByValue(Object value, Item item2);
	
}
