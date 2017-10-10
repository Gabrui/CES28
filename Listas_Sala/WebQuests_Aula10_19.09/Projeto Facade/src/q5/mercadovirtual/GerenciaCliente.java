package q5.mercadovirtual;

import q1.mercadovirtual.*;


/**
 * Criou-se um façade para encapsular o subsistema de mercadovirtual, representado
 * agora pelo GerenciaCliente. Assim, eliminou-se o mau cheiro.
 * Não se realizou alterações no subsistema original, assim ele importa as classe da questão 1.
 */
public class GerenciaCliente {
	BancoDeDados banco;
	Carrinho car;
	Cliente cliente;
	
	public GerenciaCliente (String nome, int id) {
		cliente = Cliente.create(nome, id);
		BancoDeDados banco = new BancoDeDados();
		Carrinho car = Carrinho.create();
		
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
	}
	
	public void adicionaProduto(int i) {
		Produto produto = banco.selectProduto(i);
		car.adicionar(produto);
	}
	
	public double getTotal() {
		return car.getTotal();
	}
	
	public void processarPagamento(double valor) {
		banco.processarPagamento(cliente, valor);
	}
}
