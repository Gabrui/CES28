package bancoDados;

public class Servico extends ProdutoServico {
	
	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	protected Servico(String servico, int preco, String descricao) {
		super(servico, preco, descricao);
	}
}
