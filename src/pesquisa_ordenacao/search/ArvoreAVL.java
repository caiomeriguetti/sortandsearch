package pesquisa_ordenacao.search;

import java.util.List;

import pesquisa_ordenacao.Item;
import pesquisa_ordenacao.Comparator;

public class ArvoreAVL {
    private Nodo raiz;
    private boolean h;
    private Comparator comp;
    public ArvoreAVL(Comparator comp) {
        this.raiz = null;
        this.h = true;
        this.comp = comp;
    }
    
    public boolean pesquisa(long chave) {
	    Nodo temp;

	    temp = this.pesquisa(chave, this.raiz);
	    if (temp != null)
	        return true;
	    else
	        return false;
	}
    
	private Nodo pesquisa(Object chave, Nodo no) {
	    Nodo temp = null;
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
    
    // Outros métodos
    
    public void insereRaiz(Item elem) {
        this.raiz = this.insere(elem, this.raiz);
    }
    private Nodo insere(Item elem, Nodo no) {
    	
        if (no == null) {
            Nodo novo = new Nodo(elem);
            this.h = true;
            return novo;
        } else {
            //if (elem.getChave() < no.getInfo().getChave()) {
        	if (comp.lt(elem, no.getInfo())) {
                // Insere à esquerda e verifica se precisa balancear à direita
                no.setEsq(this.insere(elem, no.getEsq()));
                no = this.balancearDir(no);
                return no;
            } else {
                // Insere à direita e verifica se precisa balancear à esquerda
                no.setDir(this.insere(elem, no.getDir()));
                no = this.balancearEsq(no);
                return no;
            }
        }

    }
    
    private Nodo balancearDir(Nodo no) {
        if (this.h)
            switch (no.getFatorBalanceamento()) {
                case 1:
                    no.setFatorBalanceamento((byte) 0);
                    this.h = false;
                    break;
                case 0:
                    no.setFatorBalanceamento((byte) - 1);
                    break;
                case -1:
                    no = this.rotacaoDireita(no);
            }
        return no;
    }
    
    private Nodo balancearEsq(Nodo no) {
        if (this.h)
            switch (no.getFatorBalanceamento()) {
                case -1:
                    no.setFatorBalanceamento((byte) 0);
                    this.h = false;
                    break;
                case 0:
                    no.setFatorBalanceamento((byte) 1);
                    break;
                case 1:
                    no = this.rotacaoEsquerda(no);
            }
        return no;
    }
    
    private Nodo rotacaoDireita(Nodo no) {
        Nodo temp1, temp2;
        temp1 = no.getEsq();
        if (temp1.getFatorBalanceamento() == -1) {
            no.setEsq(temp1.getDir());
            temp1.setDir(no);
            no.setFatorBalanceamento((byte) 0);
            no = temp1;
        } else {
            temp2 = temp1.getDir();
            temp1.setDir(temp2.getEsq());
            temp2.setEsq(temp1);
            no.setEsq(temp2.getDir());
            temp2.setDir(no);
            if (temp2.getFatorBalanceamento() == -1)
                no.setFatorBalanceamento((byte) 1);
            else
                no.setFatorBalanceamento((byte) 0);
            if (temp2.getFatorBalanceamento() == 1)
                temp1.setFatorBalanceamento((byte) - 1);
            else
                temp1.setFatorBalanceamento((byte) 0);
            no = temp2;
        }
        no.setFatorBalanceamento((byte) 0);
        this.h = false;
        return no;
    }
    
    private Nodo rotacaoEsquerda(Nodo no) {
        Nodo temp1, temp2;
        temp1 = no.getDir();
        if (temp1.getFatorBalanceamento() == 1) {
            no.setDir(temp1.getEsq());
            temp1.setEsq(no);
            no.setFatorBalanceamento((byte) 0);
            no = temp1;
        } else {
            temp2 = temp1.getEsq();
            temp1.setEsq(temp2.getDir());
            temp2.setDir(temp1);
            no.setDir(temp2.getEsq());
            temp2.setEsq(no);
            if (temp2.getFatorBalanceamento() == 1)
                no.setFatorBalanceamento((byte) - 1);
            else
                no.setFatorBalanceamento((byte) 0);
            if (temp2.getFatorBalanceamento() == -1)
                temp1.setFatorBalanceamento((byte) 1);
            else
                temp1.setFatorBalanceamento((byte) 0);
            no = temp2;
        }
        no.setFatorBalanceamento((byte) 0);
        this.h = false;
        return no;
    }
    
    public Item search(Object key) {
		Nodo found = this.pesquisa(key, this.raiz);
		
		if (found != null) {
			return found.getInfo();
		}
		
		return null;
	}
	
    public void load(List<Item> l) {
		for (Item item : l) {
			insereRaiz(item);
		}
	}
    
    private Item removed;
    public Item remove(Object item) {
    	removed = null;
		remove(item, raiz);
		return removed;
	}
	
	private Nodo remove(Object item, Nodo arv) {
	    if (arv == null) {
	        return arv;
	    } else {
	        //if (chave < arv.getInfo().getChave())
	    	if (comp.ltByValue(item, arv.getInfo())) {
	            arv.setEsq(this.remove(item, arv.getEsq()));
	    	} else
	        //if (chave > arv.getInfo().getChave())
	        if (comp.gtByValue(item, arv.getInfo())) {
	            arv.setDir(this.remove(item, arv.getDir()));
	        } else if (arv.getDir() == null) {
	        	removed = arv.getInfo();
	        	if (arv == raiz) {
	        		raiz = arv.getEsq();
	        	} else {
	        		return arv.getEsq();
	        	}
	        } else if (arv.getEsq() == null) {
	        	removed = arv.getInfo();
	        	if (arv == raiz) {
	        		raiz = arv.getDir();
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
	private Nodo arruma(Nodo Q, Nodo R) {
	    if (R.getDir() != null)
	        R.setDir(this.arruma(Q, R.getDir()));
	    else {
	        Q.setInfo(R.getInfo());
	        R = R.getEsq();
	    }
	    return R;
	}
	
}