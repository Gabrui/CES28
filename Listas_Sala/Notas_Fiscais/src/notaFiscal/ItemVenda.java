package notaFiscal;
import db.*;

public class ItemVenda {
	private BDProduto bancoDadosRemoto;
	private ProdutoAbstrato produto;
	private String nome;
	private int quantidade;
	
	public ItemVenda (String nome, int quantidade) {
		// Deveria se inicializar bancoDadosRemoto;
		this.quantidade = quantidade;
		this.nome = nome;
		produto = bancoDadosRemoto.getProdutoServico(nome);
	}
	
	public int getValor() {
		return produto.getPreco()*quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ItemVenda) {
			return ((ItemVenda) o).nome.equals(nome);
		}
		return false;
	}
}
