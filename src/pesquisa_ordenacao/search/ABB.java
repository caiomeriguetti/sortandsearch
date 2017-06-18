package pesquisa_ordenacao.search;

import java.util.ArrayList;
import java.util.List;

import pesquisa_ordenacao.Comparator;
import pesquisa_ordenacao.Item;
import pesquisa_ordenacao.NoArvore;

public class ABB {
	protected NoArvore raiz;
	public NoArvore getRaiz() {
		return raiz;
	}
	
	public void setRaiz(NoArvore raiz) {
		this.raiz = raiz;
	}

	private Comparator comp;
	
    public ABB(Comparator comp) {
        this.raiz = null;
        this.comp = comp;
    } //métodos (inclusive os de inserção, remoção e pesquisa)
	
    public Item search(Object key) {
		NoArvore found = this.pesquisa(key, this.raiz);
		
		if (found != null) {
			return found.getInfo();
		}
		
		return null;
	}
	
	public void load(List<Item> l) {
		
		int k = 0;
		for (Item item : l) {
			insere(item);

			k++;
			
			/**
			 * EXPLICACAO
			 * 
			 * A cada 200 elementos inseridos rebalanceia a arvore
			 * 
			 * */
			
			if (k%200== 0) {
				ABB temp = ArvoreBalanceada(CamCentral(new ArrayList<>()));
				this.setRaiz(temp.getRaiz());
			}
		}
		
	}
	
	public boolean pesquisa(Object chave) {
	    NoArvore temp;

	    temp = this.pesquisa(chave, this.raiz);
	    if (temp != null)
	        return true;
	    else
	        return false;
	}
	private NoArvore pesquisa(Object chave, NoArvore no) {
	    NoArvore temp = null;
	    temp = no;

	    if (temp != null) {
	        //if (chave < temp.getInfo().getChave())
	    	if (comp.ltByValue(chave, temp.getInfo()))
	            temp = this.pesquisa(chave, temp.getEsq());
	        else {
	            //if (chave > temp.getInfo().getChave())
	        	if (comp.gtByValue(chave, temp.getInfo()))
	                temp = this.pesquisa(chave, temp.getDir());
	        }
	    }
	    return temp;
	}
	
	public boolean insere(Item elem) {
	    boolean existe;
		
	    /**
	     * EXPLICACAO
	     * 
	     * é necessário aceitar elementos iguais
	     * pois como a nossa chave é a cidade
	     * o comparador iria considerar todos os
	     * elementos da mesma cidade iguais e 
	     * iria inserir somente o primeiro
	     * 
	     * */
	    
//	    existe = this.pesquisa(s.getKey(elem));
	    
	    existe = false;
	    if (existe) {
	        return false;
		} else {
	        this.raiz = this.insere(elem, this.raiz);
	        return true;
	    }
	}

	private NoArvore insere(Item elem, NoArvore no) {
	    NoArvore novo;

	    if (no == null) {
	        novo = new NoArvore(elem);
	        return novo;
	    } else {
	        //if (elem.getChave() < no.getInfo().getChave()) {
	    	if (comp.lt(elem, no.getInfo())) {
	            no.setEsq(this.insere(elem, no.getEsq()));
	            return no;
	        } else {
	        	/**
	        	 * EXPLICACAO
	        	 * 
	        	 * Elementos maiores ou iguais ao no
	        	 * vão para a sua direita
	        	 * 
	        	 * */
	            no.setDir(this.insere(elem, no.getDir()));
	            return no;
	        }
	    }
	}
	
	private Item removed;
	public Item remove(Object item) {
		removed = null;
		remove(item, raiz);
		return removed;
	}
	
	private NoArvore remove(Object item, NoArvore arv) {
	    if (arv == null) {
	        return arv;
	    } else {
	        //if (chave < arv.getInfo().getChave())
	    	if (comp.ltByValue(item, arv.getInfo())) {
	            arv.setEsq(this.remove(item, arv.getEsq()));
	    	} else if (comp.gtByValue(item, arv.getInfo())) {
	    	//} else if (chave > arv.getInfo().getChave()) {
	            arv.setDir(this.remove(item, arv.getDir()));
	        } else if (arv.getDir() == null) {
	        	removed = arv.getInfo();
	        	if (arv == raiz) {
	        		raiz = arv.getEsq();
	        		return raiz;
	        	} else {
	        		return arv.getEsq();
	        	}
	        } else if (arv.getEsq() == null) {
	        	removed = arv.getInfo();
	        	if (arv == raiz) {
	        		raiz = arv.getDir();
	        		return raiz;
	        	} else {
	        		return arv.getDir();
	        	}
	        } else {
	        	removed = arv.getInfo();
	            arv.setEsq(this.arruma(arv, arv.getEsq()));
	        }
	    }
	    return arv;
	}
	private NoArvore arruma(NoArvore Q, NoArvore R) {
	    if (R.getDir() != null)
	        R.setDir(this.arruma(Q, R.getDir()));
	    else {
	        Q.setInfo(R.getInfo());
	        R = R.getEsq();
	    }
	    return R;
	}
	

	public List<Item> CamCentral(List<Item> vetOrdenado) {
	    return (this.FazCamCentral(this.raiz, vetOrdenado));
	}
	private List<Item> FazCamCentral(NoArvore arv, List<Item> vetOrdenado) {
	    if (arv != null) {
	        vetOrdenado = this.FazCamCentral(arv.getEsq(), vetOrdenado);
	        vetOrdenado.add(arv.getInfo());
	        vetOrdenado = this.FazCamCentral(arv.getDir(), vetOrdenado);
	    }
	    return vetOrdenado;
	}
	
	private void Balancear(List<Item> vet, ABB temp, int inic, int fim) {
	    int meio;
	    if (fim >= inic) {
	        meio = (inic + fim) / 2;
	        temp.insere(vet.get(meio));
	        this.Balancear(vet, temp, inic, meio - 1);
	        this.Balancear(vet, temp, meio + 1, fim);
	    }
	}
	
	public ABB ArvoreBalanceada(List<Item> vetOrdenado) {
	    ABB temp = new ABB(comp);
	    this.Balancear(vetOrdenado, temp, 0, vetOrdenado.size() - 1);
	    return temp;
	}
	

}
