package q1.application;

import q1.mercadovirtual.BancoDeDados;
import q1.mercadovirtual.Carrinho;
import q1.mercadovirtual.Cliente;
import q1.mercadovirtual.Produto;
public class Aplicacao {
	public static void main(String[] args) {
		BancoDeDados banco = new BancoDeDados();
		// registrar comprador
		Cliente cliente = Cliente.create("ZÉ", 123);
		Carrinho car = Carrinho.create();
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
		// realizar uma compra
		Produto produto = banco.selectProduto(223);
		cliente.getCarrinho().adicionar(produto);
		// realizar outra compra
		Produto produto2 = banco.selectProduto(342);
		cliente.getCarrinho().adicionar(produto2);
		// fechar compra
		double valor = cliente.getCarrinho().getTotal();
		banco.processarPagamento(cliente, valor);
	}
}
