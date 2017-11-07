package bancoDados;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscalBuilder;

public class BDfake implements BD {
	
	private HashMap<String,String> _CategoriaProdutos;
	private HashMap<String,Integer> _PrecoProdutos;
	private HashMap<String,String> _DescricaoProdutos;
	private HashMap<String,List<String>> _ComposicaoProdutos;
	private DataObjectNumeroDeProdutos _DON;
	//List<MyType> myList = new ArrayList<MyType>();
	public BDfake(){
		_CategoriaProdutos  = new HashMap<String,String>();
		_PrecoProdutos      = new HashMap<String,Integer>();
		_DescricaoProdutos  = new HashMap<String,String>();
		_ComposicaoProdutos = new HashMap<String,List<String>>();
		_DON                = new DataObjectNumeroDeProdutos();
		/**
		 * Categorias
		 */
		_CategoriaProdutos.put("banana", "fruta");
		_CategoriaProdutos.put("pera", "fruta");
		_CategoriaProdutos.put("laranja", "fruta");
		_CategoriaProdutos.put("cesta_de_frutas", "nao-taxavel");
		/**
		 *Preços
		 */
		_PrecoProdutos.put("banana", 1);
		_PrecoProdutos.put("pera", 2);
		_PrecoProdutos.put("laranja", 3);
		_PrecoProdutos.put("cesta_de_frutas", 2);
		/**
		 * Descrições
		 */
		_DescricaoProdutos.put("banana", "uma fruta amarela");
		_DescricaoProdutos.put("pera", "uma fruta verde");
		_DescricaoProdutos.put("laranja", "uma fruta laranja ;D");
		_DescricaoProdutos.put("cesta_de_frutas", "uma cesta com frutas");
		/**
		 * Composições
		 */
		_ComposicaoProdutos.put("cesta_de_frutas", Arrays.asList("pera", "laranja", "banana") );

	}
	@Override
	public ProdutoServico getProdutoServico(String nome) {
		return buildProduto(nome);
	}
	
	
	
	private ProdutoServico buildProduto(String nome) {
		String categoria = _CategoriaProdutos.get(nome);
		String descricao = _DescricaoProdutos.get(nome);
		Integer preco    = _PrecoProdutos.get(nome);
		List<String> composicao  = _ComposicaoProdutos.get(nome);
		if(categoria != null) {
			if(composicao == null) {
				return new Produto(nome,preco,descricao,categoria);
			}
			else {
				boolean flag = true;
				ProdutoServicoComposto prod = null;
				for (String element : composicao) {
					ProdutoServico temp = buildProduto(element);
					if(flag) {
						prod = new ProdutoServicoComposto(nome,preco,descricao,categoria,temp);
						flag = false;
					}
					else {
						prod.adicionaComponente(temp);
					}
				}
				return prod;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public NotaFiscalBuilderValidado validaNotaFiscal(NotaFiscalBuilder NFB) {
		int TaxaFinal = 0;
		List<Imposto> impostos = _DON.getAllImposto();
		List<ItemVenda> produtos = NFB.getListaItens();
		for (Imposto imposto : impostos) {
			for(ItemVenda item : produtos) {
				imposto.taxar(item);
			}
			TaxaFinal += imposto.getImpostoTotal();
		}
		//NFB.setTaxa() //TODO AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
