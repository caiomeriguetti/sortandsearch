package pesquisa_ordenacao;

public class Item {
	private String nome, cpf, cidade;
	private Item next;
	
	public Item getNext() {
		return next;
	}
	public void setNext(Item next) {
		this.next = next;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String toString() {
		return "[nome="+nome+", cpf="+cpf+", cidade="+cidade+"]";
	}
	
	public boolean gt(Item item) {
		return false;
	}
}
