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
	private DataObjectfake _DON;
	private int _IDMaker = 1;
	//List<MyType> myList = new ArrayList<MyType>();
	public BDfake(){
		_CategoriaProdutos  = new HashMap<String,String>();
		_PrecoProdutos      = new HashMap<String,Integer>();
		_DescricaoProdutos  = new HashMap<String,String>();
		_ComposicaoProdutos = new HashMap<String,List<String>>();
		_DON                = new DataObjectfake();
		
		/**
		 * Frutas
		 */
		addProduto("banana",1,"uma fruta amarela","fruta");
		addProduto("pera",2,"uma fruta verde","fruta");
		addProduto("laranja",3,"uma fruta laranja ","fruta");
		addComposto("cesta de frutas",2,"uma cesta de frutas","nao-taxavel",Arrays.asList("pera", "laranja", "banana"));
		/**
		 * Eletronicos
		 */
		addProduto("GPU ATX",2500,"gpu top de linha","eletronicos");
		addProduto("Final Fantasy 19",199,"jogo de rpg","jogos eletronicos");
		addComposto("Pacote ATX",0,"ATX + FF19","nao-taxavel",Arrays.asList("GPU ATX","Final Fantasy 19"));
		addProduto("Motherboard MOTHER",1000,"placa mae","eletronicos");
		addProduto("Fonte NRG",1200,"fonte","eletronicos");
		addProduto("Gabinete PIRATE",500,"gabinete","eletronicos");
		addProduto("Mao de obra",400,"mao de obra","nao-taxavel");
		addComposto("PC Gamer",0,"pc gamer top de linha","nao-taxavel",Arrays.asList("Pacote ATX","Motherboard MOTHER","Fonte NRG","Gabinete PIRATE","Mao de obra"));
		

	}
	@Override
	public ProdutoServico getProdutoServico(String nome) {
		return buildProduto(nome);
	}
	
	private void addProduto(String name,int preco, String descricao, String categoria) {
		_CategoriaProdutos.put(name, categoria);
		_PrecoProdutos.put(name, preco);
		_DescricaoProdutos.put(name, descricao);
	}
	
	private void addComposto(String name,int preco, String descricao, String categoria, List<String> compostos) {
		_CategoriaProdutos.put(name, categoria);
		_PrecoProdutos.put(name, preco);
		_DescricaoProdutos.put(name, descricao);
		_ComposicaoProdutos.put(name, compostos );
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
		List<Imposto> impostos = _DON.getAllImposto();
		for (Imposto imposto : impostos) {
			NFB.accept(imposto);
		}
		
		NotaFiscalBuilderValidado NFBv = new NotaFiscalBuilderValidado(NFB, _IDMaker);
		_IDMaker +=1;
		return NFBv;
	}

}
