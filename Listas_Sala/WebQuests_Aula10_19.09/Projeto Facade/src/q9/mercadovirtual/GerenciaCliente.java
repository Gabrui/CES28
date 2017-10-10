package q9.mercadovirtual;


/**
 * Métodos são apenas delegações
 */
public class GerenciaCliente {
	private BancoDeDados banco;
	private Cliente cliente;
	private Produto ultimoProdutoAdicionado;
	private static int ultimoClienteID = 0;
	
	public GerenciaCliente (String nome) {
		cliente = Cliente.create(nome, ultimoClienteID++);
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
