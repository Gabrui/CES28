package bancoDados;

import java.util.List;

import notaFiscal.ItemVenda;

//Requisito 16. A classe ProdutoServicoComposto nao possui metodos publicos de modificacao
//de seus atributos, pois é um imutable object.
public class ProdutoServicoComposto extends ProdutoServico {
	

	private List<ProdutoServico> componentes;

	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	protected ProdutoServicoComposto(String nome, String descricao, List<ProdutoServico> componentes) {
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

	//Requisito 16. Só o BD e as classes podem modificar os atributos de P/S. Imutable Object.
	protected void adicionaComponente(ProdutoServico componente) {
		componentes.add(componente);
	}
	@Override
	public void visit(Imposto imp,int quant) {//DP visitor Requisito 10
		// TODO Auto-generated method stub
		for (ProdutoServico i : componentes)
			i.visit(imp,1);
		imp.taxar(this, quant);
	}

}
