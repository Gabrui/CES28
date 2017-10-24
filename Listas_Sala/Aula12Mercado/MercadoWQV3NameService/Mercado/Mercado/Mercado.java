package Mercado;

import Infraestrutura.IBancoDados;
import Infraestrutura.FakeNameService;


public class Mercado {

		private IBancoDados banco_; 
		public Mercado(String banco) {
			this.setBanco(banco);
		}
		
		public void registraComprador(String name, int id) {
			// 	registrar comprador
			Cliente cliente = Cliente.create(name, id);
			Carrinho car = Carrinho.create();
			cliente.adicionarCarrinho(car);
			banco_.registrarCliente(cliente);
		}
		// realizar uma compra
		public void compra(int cliId, int prodId) {
			Cliente cliente = banco_.selectCliente(cliId);
			Produto produto = banco_.selectProduto(prodId);
			cliente.getCarrinho().adicionar(produto);
		}
		// fechar compra
		public double fecharCompra(int cliId) {
			Cliente cliente = banco_.selectCliente(cliId);
			double valor = cliente.getCarrinho().getTotal();
			banco_.processarPagamento(cliente, valor);
			return valor;
		}
		public IBancoDados setBanco(String banco) {
			this.banco_ = (IBancoDados) FakeNameService.getInstance().get(banco);
			return banco_;
		}
		
	}//Mercado


