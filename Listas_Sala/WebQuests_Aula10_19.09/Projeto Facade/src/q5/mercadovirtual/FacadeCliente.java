package q5.mercadovirtual;

public class FacadeCliente {
	private GerenciaCliente ger;
	
	public FacadeCliente(String nome, int id) {
		ger = new GerenciaCliente(nome, id);
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
