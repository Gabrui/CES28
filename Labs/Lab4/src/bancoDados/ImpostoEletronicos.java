package bancoDados;

import java.util.HashMap;

import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscal;

public class ImpostoEletronicos implements Imposto{

	private int _NumeroDeProdutosTaxados = 0;
	//private int _NewNumeroDeProdutosTaxados = 0;
	private int _taxaTotal=0;
	private int _aliquota = 10;
	private HashMap<String, Integer> _CadernoImpostos;
	
	protected ImpostoEletronicos() {
		_CadernoImpostos = new HashMap<String, Integer>();
	}
	@Override
	public void taxar(ProdutoServico analisado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(Produto analisado) {
		if(analisado.getCategoria().toLowerCase()=="eletronicos") {
			int gold = analisado.getPreco()/_aliquota;
			_taxaTotal+=gold;
			_CadernoImpostos.put(analisado.getNome(), gold);
		}
		
	}

	@Override
	public void taxar(NotaFiscal notaFiscalMutavel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(ItemVenda itemVenda) {
		taxar(itemVenda.getProduto());
	}

	@Override
	public void taxar(Servico analisado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(ProdutoServicoComposto analisado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Integer> getImpostoCalculado() {
		return _CadernoImpostos; //bad, substituir por copia
	}

	@Override
	public int getImpostoTotal() {
		int taxa_final = _taxaTotal;
		_taxaTotal = 0;
		return taxa_final;
	}

	@Override
	public String id() {
		return "ImpostoEletronicos";
	}

	@Override
	public int getRealimentacao() {
		return _NumeroDeProdutosTaxados;
	}

	@Override
	public void setRealimentacao(int dado) {
		_NumeroDeProdutosTaxados = dado;
		_taxaTotal = 0;
	}
	
	@Override
	public String toString() {
		return "Imposto sobre Eletrônicos";
	}

}
