package q7.mercadovirtual;

public class Produto {
	private String nome;
	private int id;
	private double preco;
	private Produto(String nome, int id, double preco) {
		this.nome = nome;
		this.id = id;
		this.preco = preco;
	}
	public static Produto create(String nome, int id, double preco) {
		return new Produto(nome, id, preco);
	}
	public double getPreco() {
		return preco;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
}
