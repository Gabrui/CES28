package bancoDados;

//Requisito 16. A classe Produto nao possui metodos publicos de modificacao
//de seus atributos, pois é um imutable object.
public class Produto extends ProdutoServico {
	
	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	protected Produto(String produto, int preco, String descricao) {
		super(produto, preco, descricao);
	}

	@Override
	public void visit(Imposto imp, int quant) {
		imp.taxar(this, quant);//DP visitor Requisito 10
	}
	
}
