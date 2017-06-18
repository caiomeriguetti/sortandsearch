package pesquisa_ordenacao;

public class MunicipioSearchComparator implements Comparator {

	@Override
	public boolean eqByValue(Object searchedValue, Item item) {
		String val = (String) searchedValue;
		if (val.equals(getKey(item))) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean ltByValue(Object searchedValue, Item item) {
		String municipio1 = (String) searchedValue;
		String municipio2 = (String)getKey(item);
		int comp = municipio1.compareTo(municipio2);
		
		if (comp > 0) {
			return false;
		} else if (comp < 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean gtByValue(Object searchedValue, Item item) {
		String municipio1 = (String) searchedValue;
		String municipio2 = (String)getKey(item);
		int comp = municipio1.compareTo(municipio2);
		
		if (comp > 0) {
			return true;
		} else if (comp < 0) {
			return false;
		} else {
			return false;
		}
	}

	@Override
	public boolean gt(Item item, Item item2) {
		String municipio1 = (String)getKey(item);
		return gtByValue(municipio1, item2);
	}

	@Override
	public boolean lt(Item item, Item item2) {
		String municipio1 = (String)getKey(item);
		return ltByValue(municipio1, item2);
	}

	@Override
	public boolean eq(Item item, Item item2) {
		String municipio1 = (String)getKey(item);
		return eqByValue(municipio1, item2);
	}

	@Override
	public boolean lte(Item item, Item item2) {
		String municipio1 = (String)getKey(item);
		return lteByValue(municipio1, item2);
	}

	@Override
	public boolean gte(Item item, Item item2) {
		String municipio1 = (String)getKey(item);
		return gteByValue(municipio1, item2);
	}

	@Override
	public boolean lteByValue(Object value, Item item2) {
		return ltByValue(value, item2) || eqByValue(value, item2);
	}

	@Override
	public boolean gteByValue(Object value, Item item2) {
		return gtByValue(value, item2) || eqByValue(value, item2);
	}

	@Override
	public Object getKey(Item item) {
		return item.getCidade();
	}

}
