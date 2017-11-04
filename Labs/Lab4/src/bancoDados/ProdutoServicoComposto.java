package bancoDados;

import java.util.LinkedList;
import java.util.List;

import notaFiscal.ItemVenda;

//Requisito 16. A classe ProdutoServicoComposto nao possui metodos publicos de modificacao
//de seus atributos, pois é um imutable object.
//Requisito 17. DP Composite ProdutoServicoComposto é o Composite.
//Que sabe somar todos os nós. E está acoplado com o DP visitor pelo metodo accept.
public class ProdutoServicoComposto extends ProdutoServico {
	

	private List<ProdutoServico> componentes;

	//Só BD pode criar P/S
	//Logo, o construtor de P/S deve ser protected para apenas as classes do pkg de P/S
	//poderem construir P/S, ou seja, poder criar uma relacao de composicao com BD.
	//Requisito 5.
	protected ProdutoServicoComposto(String nome, int preco, String descricao, ProdutoServico componente) {
		super(nome, preco, descricao);
		this.componentes = new LinkedList<>();
		componentes.add(componente);
	}
	
	//Requisito 17. calcula o preco somando o preco das camadas de baixo com o seu preco.
	public int getPreco() {
		int valor = super.getPreco();
		for (ProdutoServico i : componentes)
			valor += i.getPreco();
		return valor;
	}

	//Requisito 16. Só o BD e as classes podem modificar os atributos de P/S. Imutable Object.
	protected void adicionaComponente(ProdutoServico componente) {
		componentes.add(componente);
	}
	
	@Override
	public void accept(Imposto imp) {//DP visitor Requisito 10
		for (ProdutoServico i : componentes)
			i.accept(imp);
		imp.taxar(this);
	}

}
