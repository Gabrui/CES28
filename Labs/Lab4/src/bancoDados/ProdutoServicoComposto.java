package bancoDados;

import java.util.List;

public class ProdutoServicoComposto extends ProdutoServico {
	

	private List<ProdutoServico> componentes;

	public ProdutoServicoComposto(String nome, String descricao, List<ProdutoServico> componentes) {
		super(nome, preco, descricao);
		this.componentes = componentes;
	}
	

	protected void adicionaComponente(ProdutoServico componente) {
		componentes.add(componente);
	}

}
