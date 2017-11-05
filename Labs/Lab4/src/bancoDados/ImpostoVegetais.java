package bancoDados;

import java.util.HashMap;

import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscal;

public class ImpostoVegetais implements Imposto {

	private int _NumeroDeProdutosTaxados = 0;
	private int _taxaTotal=0;
	@Override
	public void taxar(ProdutoServico analisado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(Produto analisado) {
		if(analisado.getNome().toLowerCase()=="fruta") {
			_NumeroDeProdutosTaxados +=1;
		}
		
	}

	@Override
	public void taxar(NotaFiscal notaFiscal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(ItemVenda itemVenda) {
		_taxaTotal+=itemVenda.getQuantidade()*.2*_NumeroDeProdutosTaxados;
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getImpostoTotal() {
		return _taxaTotal;
	}

	@Override
	public String id() {
		return "ImpostoVegetais";
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
}
