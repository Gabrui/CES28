package notaFiscal;
import bd.*;

public class ItemVenda {
	private BD bancoDadosRemoto;
	private ProdutoAbstrato produto;
	private String nome;
	private int quantidade;
	
	public ItemVenda (BD bancoRemoto, String nome, int quantidade) {
		this.bancoDadosRemoto = bancoRemoto;
		this.quantidade = quantidade;
		this.nome = nome;
		produto = bancoDadosRemoto.getProdutoServico(nome);
		if (produto == null)
			throw new IllegalArgumentException("O produto não existe!");
			
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
