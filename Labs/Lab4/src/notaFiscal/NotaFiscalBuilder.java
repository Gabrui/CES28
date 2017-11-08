package notaFiscal;

import java.util.HashMap;
import java.util.LinkedList;

import bancoDados.BD;
import bancoDados.Imposto;

public class NotaFiscalBuilder {

	protected LinkedList<ItemVenda> listaItens;
	private BD bd;
	private boolean validada; //Requisito 6
	private HashMap<String, Integer> _taxasCobradas;
	private int _TaxaTotal = 0;
	private String outros;
	private int _ID;
	
	
	public NotaFiscalBuilder(BD bd) {
		this.bd = bd;
		listaItens = new LinkedList<ItemVenda>();
	}
	
	public void setOutros(String outros) {
		this.outros = outros;
	}
	
	// Usado pelo BD durante a validação
	protected void setID(int ID) {
		this._ID = ID;
	}
	protected void validacaoAceita() {
		this.validada = true;
	}
	protected void setTaxasCobradas(HashMap<String, Integer> taxasCobradas) {
		this._taxasCobradas = taxasCobradas;
	}
	protected void setTaxaTotal(int taxa) {
		this._TaxaTotal = taxa;
	}
	
	public int getTaxaTotal() {
		return this._TaxaTotal;
	}
	
	public BD getBD() {
		return bd;
	}
	
	public NotaFiscal buildEsboco() {
		if (listaItens.isEmpty())
			throw new IllegalArgumentException("Nota fiscal vazia!");
		return new NotaFiscal(this);
	}
	
	public NotaFiscal valida() {
		if (listaItens.isEmpty())
			throw new IllegalArgumentException("Nota fiscal vazia!");
		this.setTaxaTotal(0);
		return new NotaFiscal(bd.validaNotaFiscal(this));
	}

    //Metodo de acesso para o id. Como é um int nao há risco de modificacao por agente externo.
	public int getID() {
		return _ID;
	}
	
	public boolean isValidada() {
		return validada;
	}
	
	@SuppressWarnings("unchecked")
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	//Requisito 13. Metodo apropriado de modificacao da lista
	//A lista retornada é clonada, mas como os itens de venda são Imutáveis, não há como alterar a lista original
	public LinkedList<ItemVenda> getListaItens() {
		return (LinkedList<ItemVenda>) listaItens.clone();
	}
	
	@SuppressWarnings("unchecked")
	//O Hash retornada é clonado.
	public HashMap<String, Integer> getTaxasCobradas() {
		if (_taxasCobradas == null)
			return null;
		return (HashMap<String, Integer>) _taxasCobradas.clone();
	}
	
	//Requisito 8. NotaFiscal sabe dos impostos cobrados e sabe o valor deles.
	public int valorCobradoImposto(String nomeImposto) {
		return _taxasCobradas.get(nomeImposto);
	}
	
	public String getOutros() {
		return outros;
	}
	
	//DP visitor Requisito 10
		public void accept(Imposto imp) {
			for(ItemVenda i:listaItens) {
				i.accept(imp);
			}
			_TaxaTotal += imp.getImpostoTotal();
		}
		
	
    
	//Requisito 13. Metodo apropriado de modificacao da lista
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	public void adicionaItem(String item, int quant) {
		if (quant <= 0)
			throw new IllegalArgumentException("A quantidade não pode ser nula ou negativa.");
		listaItens.add(new ItemVenda(bd, item, quant)); 
		//Se o P/S nao existir o BD deve lancar uma excecao.
		//Logo, NotaFiscal sempre tem pelo menos um item de venda (Requisito 1).
		//ItemVenda recebe P/S do BD. Só o BD cria P/S.
		//Todo Item de Venda é criado dentro da NotaFiscal na hora de adicionar
		//E o construtor de Item de Venda é protected compartilhando a mesma pkg que NotaFiscal
		//Logo, Cada Item de venda pertence apenas a uma NotaFiscal.
	}
	
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	//Requisito 13. Metodo apropriado de modificacao da lista
	@SuppressWarnings("unlikely-arg-type")
	public void deletaItem(String nomeItem) {
		if (listaItens.contains(nomeItem)) {
			if (listaItens.size() == 1)
				throw new IllegalArgumentException("A lista não pode ficar vazia.");
			
			listaItens.remove(nomeItem);
		}
	}
}
