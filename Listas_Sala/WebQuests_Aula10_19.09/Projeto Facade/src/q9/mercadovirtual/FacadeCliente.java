package q9.mercadovirtual;

public class FacadeCliente {
	private GerenciaCliente ger;
	
	public FacadeCliente(String nome) {
		ger = new GerenciaCliente(nome);
	}

	public void adicionaProduto(int i) {
		ger.adicionaProduto(i);
	}
	
	public double getTotal() {
		return ger.getTotal();
	}
	
	public void processarPagamento(double valor) {
		ger.processarPagamento(valor);
	}

}
