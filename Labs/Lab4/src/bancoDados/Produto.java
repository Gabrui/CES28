package bancoDados;

//Requisito 16. A classe Produto nao possui metodos publicos de modificacao
//de seus atributos, pois é um imutable object.
public class Produto extends ProdutoServico {
	
	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	//Requisito 17. DP Composite. Produto é uma leaf.
	protected Produto(String produto, int preco, String descricao, String categoria) {
		super(produto, preco, descricao,categoria);
	}

	//DP visitor Requisito 10
	@Override
	public void accept(Imposto imp) {
		imp.taxar(this);
	}
	
}
