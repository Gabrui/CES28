package notaFiscal;
import db.*;

public class ItemVenda {
	private BDProduto bancoDadosRemoto;
	private ProdutoAbstrato produto;
	private int quantidade;
	
	public ItemVenda (String nome, int quantidade) {
		// Deveria se inicializar bancoDadosRemoto;
		this.quantidade = quantidade;
		produto = bancoDadosRemoto.getProdutoServico(nome);
	}
	
	public int getValor() {
		return produto.getPreco()*quantidade;
	}
}
