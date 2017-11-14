/**
 * Codificação UTF-8
 * Gabriel Adriano
 * Dylan Sugimoto
 */

package notaFiscal;

import java.util.HashMap;
import java.util.LinkedList;
import bancoDados.*;
//Requisito 16. NotaFiscalImutavel não possui metodos publicos de modificacao de seus
//atributos. Imutable Object.
public class NotaFiscal {

	private int _ID; //Possui um id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
	private int _ValorTotal = 0;
	private HashMap<String, Integer> _taxasCobradas;//Requisito 8. NotaFiscal sabe dos impostos cobrados.
	private int _TotalTax;
	private boolean _validada;
	private LinkedList<ItemVenda> _listaItens;
	private String _outros; //NotaFiscal sabe as condicoes de entrega ...
	

	protected NotaFiscal(NotaFiscalBuilder b) {
		_validada = b.isValidada();
		_outros = b.getOutros();
		_listaItens = new LinkedList<>();
		LinkedList<ItemVenda> listaClonada =  b.getListaItens();
		if (listaClonada.isEmpty()) // Nota fiscal não pode ser vazia (Requisito 1);
			throw new IllegalArgumentException("Nota fiscal não pode ser vazia!");
		for (ItemVenda i: listaClonada) // NF cria seus próprios IV (Requisito 2)
			_listaItens.add(i.clonar());
		_ID = b.getID();//id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
		_taxasCobradas = b.getTaxasCobradas();//BD passa para NotaFiscal quais impostos e seus valores foram cobrados. (Requisito 8)
		_TotalTax = b.getTaxaTotal();
	}
	
	public String getOutros() {
		return _outros;
	}
	
	//DP visitor Requisito 10
	public void accept(Imposto imp) {
		for(ItemVenda i:_listaItens) {
			_ValorTotal += i.getValor();
			i.accept(imp);
		}
		imp.taxar(this);
	}
	
	//Requisito 8. NotaFiscal sabe dos impostos cobrados e sabe imprimir eles.
	public String imprimirImpostoCobrado() {
		String impressao = "";
		impressao = "Impostos cobrados: ";
		if (_taxasCobradas == null)
			return "\nNão foram cobrados impostos.\n";
		for (String key : _taxasCobradas.keySet())
			impressao = "\n     "+key+_taxasCobradas.get(key).toString();
		return impressao;
	}
	
	//Requisito 13. Metodo apropriado de acesso da lista
	//Requisito 17. calcula o preco percorrendo a arvore de todos itens de venda e 
	//soma todos os nós.
	public int getValor() {
		int valor = 0;
		for (ItemVenda i : _listaItens)
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
		for (ItemVenda i : _listaItens)
			if (i.equals(nomeItem))
				return i.getQuantidade();
		return 0;
	}
	
	//Requisito 13. Metodo apropriado de acesso aos nomes dos itens
	public String nomeItens() {
		String nomeSet ="";
		for (ItemVenda i : _listaItens)
				nomeSet += i.nome()+"\n";
		return nomeSet;
	}
	
	//Requisito 21. Imprimir
	public String imprimir() {
		String impressao = "Nome	Preço por unidade	Qtd		Total\n\n";
		if (_validada)
			impressao +="ID: " + _ID;
		else
			impressao += "Em construção";
		for (ItemVenda i : _listaItens)
				impressao += "\n" + i.imprimir();
		impressao += "\n\nTotal sem impostos = " + _ValorTotal +"\n";
		impressao += imprimirImpostoCobrado();
		return impressao;
	}
	
	public int getTaxaTotal() {
		return _TotalTax;
	}
	
	public int getID() {
		return _ID;
	}
}
