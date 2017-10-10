package q9.mercadovirtual;


/**
 * Métodos são apenas delegações
 */
public class GerenciaCliente {
	private BancoDeDados banco;
	private Cliente cliente;
	private Produto ultimoProdutoAdicionado;
	
	public GerenciaCliente (String nome, int id) {
		cliente = Cliente.create(nome, id);
		BancoDeDados banco = BancoDeDados.getInstance();
		banco.registrarCliente(cliente);
	}
	
	public void adicionaProduto(int i) {
		ultimoProdutoAdicionado = banco.selectProduto(i);
		cliente.adicionar(ultimoProdutoAdicionado);
	}
	
	public double getTotal() {
		return cliente.getTotal();
	}
	
	public void processarPagamento(double valor) {
		banco.processarPagamento(cliente, valor);
	}
}
