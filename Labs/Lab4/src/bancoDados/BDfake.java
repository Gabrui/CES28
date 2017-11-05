package bancoDados;



import java.util.HashMap;

import notaFiscal.NotaFiscalBuilder;

public class BDfake implements BD {
	
	private HashMap<String,String> _CategoriaProdutos;
	private HashMap<String,Integer> _PrecoProdutos;
	private HashMap<String,String> _DescricaoProdutos;
	
	public BDfake(){
		_CategoriaProdutos = new HashMap<String,String>();
		_PrecoProdutos = new HashMap<String,Integer>();
		_DescricaoProdutos = new HashMap<String,String>();
		/**
		 * Categorias
		 */
		_CategoriaProdutos.put("banana", "fruta");
		_CategoriaProdutos.put("pera", "fruta");
		_CategoriaProdutos.put("laranja", "fruta");
		/**
		 *Preços
		 */
		_PrecoProdutos.put("banana", 1);
		_PrecoProdutos.put("pera", 2);
		_PrecoProdutos.put("laranja", 3);
		/**
		 * Descrições
		 */
		_DescricaoProdutos.put("banana", "uma fruta amarela");
		_DescricaoProdutos.put("pera", "uma fruta verde");
		_DescricaoProdutos.put("laranja", "uma fruta laranja ;D");
	}
	@Override
	public ProdutoServico getProdutoServico(String nome) {
		String categoria = _CategoriaProdutos.get(nome);
		String descricao = _DescricaoProdutos.get(nome);
		Integer preco    = _PrecoProdutos.get(nome);
		if(categoria != null) {
			return new Produto(nome,preco,descricao,categoria);
		}
		else {
			return null;
		}
	}


	@Override
	public NotaFiscalBuilderValidado validaNotaFiscal(NotaFiscalBuilder nota) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculaImposto(ProdutoServico ps) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Imposto getRegra(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
