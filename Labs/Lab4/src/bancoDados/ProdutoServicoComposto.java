package bancoDados;

import java.util.List;

import notaFiscal.ItemVenda;

public class ProdutoServicoComposto extends ProdutoServico {
	

	private List<ProdutoServico> componentes;

	public ProdutoServicoComposto(String nome, String descricao, List<ProdutoServico> componentes) {
		super(nome, 0, descricao);
		this.componentes = componentes;
		setPreco(calculaPreco());
	}
	protected int calculaPreco() {
		
		int valor = 0;
		for (ProdutoServico i : componentes)
			valor += i.getPreco();
		return valor;
	}

	protected void adicionaComponente(ProdutoServico componente) {
		componentes.add(componente);
	}

}
