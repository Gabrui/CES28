package q9.mercadovirtual;

public class Cliente {
	private int id;
	private String nome;
	private Carrinho carrinho;
	private Cliente(String nome, int id) {
		this.id = id;
		this.nome = nome;
		this.carrinho = Carrinho.create();
	}
	public static Cliente create(String nome, int id) {
		return new Cliente(nome, id);
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public double getTotal() {
		return carrinho.getTotal();
	}
	public void adicionar(Produto selectProduto) {
		carrinho.adicionar(selectProduto);
	}
}
