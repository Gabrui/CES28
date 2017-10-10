package q9.application;

import q9.mercadovirtual.FacadeCliente;

/**
 * O banco de dados agora é um singleton.
 */
public class Aplicacao {
	public static void main(String[] args) {
		FacadeCliente g = new FacadeCliente("ZÉ", 123);
		g.adicionaProduto(223);
		g.adicionaProduto(342);
		double valor = g.getTotal();
		g.processarPagamento(valor);
	}
}