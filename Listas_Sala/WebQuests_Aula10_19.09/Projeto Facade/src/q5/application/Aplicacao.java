package q5.application;

import q5.mercadovirtual.GerenciaCliente;

/**
 * Criou-se um façade para encapsular o subsistema de mercadovirtual, representado
 * agora pelo GerenciaCliente. Assim, eliminou-se o mau cheiro.
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
