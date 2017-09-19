package q2.application;

import q2.mercadovirtual.GerenciaCliente;
public class Aplicacao {
	public static void main(String[] args) {
		GerenciaCliente g = new GerenciaCliente("ZÉ", 123);
		g.adicionaProduto(223);
		g.adicionaProduto(342);
		double valor = g.getTotal();
		g.processarPagamento(valor);
	}
}
