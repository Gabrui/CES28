package q7.application;

import q5.mercadovirtual.GerenciaCliente;

/**
 * O banco de dados agora é um singleton.
 */
public class Aplicacao {
	public static void main(String[] args) {
		GerenciaCliente g = new GerenciaCliente("ZÉ", 123);
		g.adicionaProduto(223);
		g.adicionaProduto(342);
		double valor = g.getTotal();
		g.processarPagamento(valor);
	}
}
