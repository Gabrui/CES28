package bancoDados;

import java.util.List;

public interface BD {
	private List<DataObject> _tabelaPS;
	private List<Imposto> _tabelaImposto;
	public ProdutoServico getProdutoServico(String nome);
	public Cliente getCliente(String CPF);
}
