package q8.mercadovirtual;

import q7.mercadovirtual.*;

/**
 * Métodos são apenas delegações
 */
public class GerenciaCliente {
	BancoDeDados banco;
	Carrinho car;
	Cliente cliente;
	
	public GerenciaCliente (String nome, int id) {
		cliente = Cliente.create(nome, id);
		BancoDeDados banco = BancoDeDados.getInstance();
		Carrinho car = Carrinho.create();
		
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
	}
	
	public void adicionaProduto(int i) {
		car.adicionar(banco.selectProduto(i));
	}
	
	public double getTotal() {
		return car.getTotal();
	}
	
	public void processarPagamento(double valor) {
		banco.processarPagamento(cliente, valor);
	}
}
