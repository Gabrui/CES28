package notaFiscal;
import bancoDados.*;

public class ItemVenda {
	private BD bancoDadosRemoto;
	//Requisito 17. ItemVenda tem um ProdutoServico que é um Component.
	private ProdutoServico produto;//Cada Item de venda se refere apenas um P/S
	private String nome;
	private int quantidade;
	
	//Construtor protected Requisito 2. 
	//ItemVenda só pode ser criado por classes da mesma pkg.
	//Só NotaFiscal é da mesma pkg que ItemVenda.
	//Logo, só NotaFiscal cria ItemVenda.
	protected ItemVenda (BD bancoRemoto, String nome, int quantidade) {
		this.bancoDadosRemoto = bancoRemoto;
		this.quantidade = quantidade;
		this.nome = nome;
		produto = bancoDadosRemoto.getProdutoServico(nome);
		//ItemVenda recebe P/S do BD. Só o BD cria P/S (Requisito 5).
		if (produto == null)
			throw new IllegalArgumentException("O produto não existe!");
			
	}
	
	public int getValor() {
		return produto.getPreco()*quantidade;
	}
	
	public ProdutoServico getProduto() {
		return bancoDadosRemoto.getProdutoServico(produto.getNome());//bad
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public String nome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ItemVenda) {
			return ((ItemVenda) o).nome.equals(nome);
		} else if (o instanceof String) {
			return ((String) o).equals(this.nome);
		}
		return false;
	}
	
	public void accept(Imposto imp) {//DP visitor Requisito 10
		produto.accept(imp);
		imp.taxar(this);
	}

	public String imprimir() {
		String impressao = produto.imprimir() + "\t" + quantidade + "\t" + this.getQuantidade() + "\t" + this.getValor() ;
		return impressao;
	}
	
	public ItemVenda clonar() {
		return new ItemVenda(bancoDadosRemoto, nome, quantidade);
	}
}
