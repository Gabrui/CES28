package bancoDados;

public interface BD {
	public ProdutoServico getProdutoServico(String nome);
	public Cliente getCliente(String CPF);
}
