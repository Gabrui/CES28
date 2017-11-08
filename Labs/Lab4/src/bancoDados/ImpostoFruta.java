package bancoDados;

import java.util.HashMap;

import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscal;

public class ImpostoFruta implements Imposto{

	private int _NumeroDeProdutosTaxados = 0;
	private int _NewNumeroDeProdutosTaxados = 0;
	private int _taxaTotal=0;
	private int _aliquota = 5;
	@Override
	public void taxar(ProdutoServico analisado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(Produto analisado) {
		if(analisado.getCategoria().toLowerCase()=="fruta") {
			_taxaTotal+=analisado.getPreco()*_aliquota;
		}
		
	}

	@Override
	public void taxar(NotaFiscal notaFiscalMutavel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taxar(ItemVenda itemVenda) {
		
		_NewNumeroDeProdutosTaxados +=itemVenda.getQuantidade();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getImpostoTotal() {
		System.out.println("taxa = " + _taxaTotal);
		System.out.println("n de produtos taxados anteriormente = " + _NumeroDeProdutosTaxados );
		System.out.println("n de produtos taxados agora = " + _NewNumeroDeProdutosTaxados );
		int taxa_final = _taxaTotal*(_NumeroDeProdutosTaxados + _NewNumeroDeProdutosTaxados);
		_NumeroDeProdutosTaxados = _NewNumeroDeProdutosTaxados;
		_NewNumeroDeProdutosTaxados = 0;
		_taxaTotal = 0;
		return taxa_final;
	}

	@Override
	public String id() {
		return "ImpostoFruta";
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
