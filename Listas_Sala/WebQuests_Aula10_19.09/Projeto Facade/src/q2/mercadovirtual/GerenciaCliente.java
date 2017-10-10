package q2.mercadovirtual;

import q1.mercadovirtual.*;

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
		Produto produto = banco.selectProduto(223);
		car.adicionar(produto);
	}
	
	public double getTotal() {
		return car.getTotal();
	}
	
	public void processarPagamento(double valor) {
		banco.processarPagamento(cliente, valor);
	}
}
