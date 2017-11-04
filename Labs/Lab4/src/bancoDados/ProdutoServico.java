package bancoDados;

//Requisito 16. A classe ProdutoServico nao tem metodo publicos para modificacao de seus
//atributos, pois é uma classe imutavel.
public abstract class ProdutoServico {
	
	private String nome;
	private String descricao;
	private int preco;
	protected String _categoriaTributaria;
	
	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	//Requisito 17. DP Composite. Servico é uma Component.
	protected ProdutoServico(String nome, int preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	//Requisito 17. Todas as camadas sabem dizer qual o seu preco.
	public int getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String descricao() {
		return descricao;
	}
	abstract public void accept(Imposto imp);//DP visitor Requisito 10
}
