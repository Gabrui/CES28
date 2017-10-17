package bancoDados;

public abstract class ProdutoServico {
	
	private String nome;
	private String descricao;
	private int preco;
	
	public ProdutoServico(String nome, int preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	
	public int getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String descricao() {
		return descricao;
	}
	
}
