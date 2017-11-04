/**
 * Codificação UTF-8
 * Gabriel Adriano
 * Dylan Sugimoto
 */

package notaFiscal;

import java.util.LinkedList;
import bancoDados.*;

public abstract class NotaFiscal {
	
	protected LinkedList<ItemVenda> listaItens;
	protected BD bancoRemoto;
	protected String _dataEntrega; //NotaFiscal sabe a data de entrega
	protected String _cEntrada; //NotaFiscal sabe as condicoes de entrega
	
	private NotaFiscal(NotaFiscalBuilder b) {
		this.bancoRemoto = b.bancoRemoto;
		listaItens = new LinkedList<>();
		for (ItemVenda i : b.listaItens)
			listaItens.add(i);
	}
	
	
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	protected void adicionaItem(String item, int quant) {
		if (quant <= 0)//Requisito 1. NotaFiscal tem pelo menos 1 Item de Venda.
			throw new IllegalArgumentException("A quantidade não pode ser nula ou negativa.");
		listaItens.add(new ItemVenda(bancoRemoto, item, quant)); 
		//Se o P/S nao existir o BD deve lancar uma excecao.
		//Logo, NotaFiscal sempre tem pelo menos um item de venda (Requisito 1).
		//ItemVenda recebe P/S do BD. Só o BD cria P/S.
		//Todo Item de Venda é criado dentro da NotaFiscal na hora de adicionar
		//E o construtor de Item de Venda é protected compartilhando a mesma pkg que NotaFiscal
		//Logo, Cada Item de venda pertence apenas a uma NotaFiscal.
	}
	
	//Requisito 13. Metodo apropriado de acesso da lista
	//Requisito 17. calcula o preco percorrendo a arvore de todos itens de venda e 
	//soma todos os nós.
	public int getValor() {
		int valor = 0;
		for (ItemVenda i : listaItens)
			valor += i.getValor();
		return valor;
	}
	
	
	//Requisito 13. Metodo apropriado de acesso da quantidade de um item
	/**
	 * Retorna a quantidade de um item
	 * @param nomeItem
	 * @return A quantidade de produtos de um item
	 */
	@SuppressWarnings("unlikely-arg-type")
	public int getQuantidade(String nomeItem) {
		for (ItemVenda i : listaItens)
			if (i.equals(nomeItem))
				return i.getQuantidade();
		return 0;
	}
	
	//Requisito 13. Metodo apropriado de acesso aos nomes dos itens
	public String nomeItens() {
		String nomeSet ="";
		for (ItemVenda i : listaItens)
				nomeSet += i.nome();
		return nomeSet;
	}
	
	//Requisito 21. Imprimir
	public String imprimir() {
		String impressao = "";
		for (ItemVenda i : listaItens)
				impressao += i.imprimir() + "\n";
		return impressao;
	}
	
	
	protected static class NotaFiscalBuilder {

		protected LinkedList<ItemVenda> listaItens;
		protected BD bancoRemoto;
		
		public NotaFiscalBuilder(BD bancoRemoto) {
			this.bancoRemoto = bancoRemoto;
			this.listaItens = new LinkedList<>();
		}
		
		public NotaFiscalBuilder adicionaItem(String item, int quant) {
			if (quant <= 0)
				throw new IllegalArgumentException("A quantidade não pode ser nula ou negativa.");
			listaItens.add(new ItemVenda(bancoRemoto, item, quant));
			return this;
		}
		
		public NotaFiscal build() {
			if (listaItens.isEmpty())
				throw new IllegalArgumentException("Não pode haver Nota Fiscal Vazia");
			return null;
		}
	}
}
