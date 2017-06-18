package pesquisa_ordenacao;

public class MunicipioNomeComparator implements Comparator {
	
	@Override
	public boolean gt(Item item1, Item item2) {
		String municipio1 = item1.getCidade();
		String municipio2 = item2.getCidade();
		int comp = municipio1.compareTo(municipio2);
		
		if (comp > 0) {
			return true;
		} else if (comp < 0) {
			return false;
		} else {
			String nome1 = item1.getNome();
			String nome2 = item2.getNome();
			
			int comp2 = nome1.compareTo(nome2);
			
			if (comp2 > 0) {
				return true;
			} else if (comp2 < 0) {
				return false;
			} else {
				return false;
			}
			
		}
	}

	@Override
	public boolean lt(Item item1, Item item2) {
		String municipio1 = item1.getCidade();
		String municipio2 = item2.getCidade();
		int comp = municipio1.compareTo(municipio2);
		
		if (comp > 0) {
			return false;
		} else if (comp < 0) {
			return true;
		} else {
			String nome1 = item1.getNome();
			String nome2 = item2.getNome();
			
			int comp2 = nome1.compareTo(nome2);
			
			if (comp2 > 0) {
				return false;
			} else if (comp2 < 0) {
				return true;
			} else {
				return false;
			}
			
		}
	}

	@Override
	public boolean eq(Item item1, Item item2) {
		String municipio1 = item1.getCidade();
		String municipio2 = item2.getCidade();
		String nome1 = item1.getNome();
		String nome2 = item2.getNome();
		int comp = municipio1.compareTo(municipio2);
		int comp2 = nome1.compareTo(nome2);
		
		if (comp == 0 && comp2 == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean lte(Item item1, Item item2) {
		return lt(item1, item2) || eq(item1, item2);
	}

	@Override
	public boolean gte(Item item1, Item item2) {
		return gt(item1, item2) || eq(item1, item2);
	}

	@Override
	public boolean gtByValue(Object value, Item item2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ltByValue(Object value, Item item2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eqByValue(Object value, Item item2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lteByValue(Object value, Item item2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gteByValue(Object value, Item item2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getKey(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}
