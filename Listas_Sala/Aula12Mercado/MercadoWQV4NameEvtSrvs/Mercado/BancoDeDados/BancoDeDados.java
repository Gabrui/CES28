package BancoDeDados;

import java.util.HashMap;
import java.util.Map;

import Mercado.Cliente;
import Mercado.Produto;

import Infraestrutura.IBancoDados;
import Infraestrutura.Subscriber;
import Infraestrutura.FakeEventService;


public class BancoDeDados extends Subscriber implements IBancoDados {
	Map<Integer, Produto> produtosById;
	Map<Integer, Cliente> clientesById;
	
	public BancoDeDados() {
		super("registraCliente");
		FakeEventService.getInstance().addSubscriber(this);
		produtosById = new HashMap<>();
		clientesById = new HashMap<>();
		for (int i = 0; i < 500; i++) {
			produtosById.put(new Integer(i), Produto.create("Produto #" + i, i, (double)(i*3 + 1)));
		}
	}
	public Cliente selectCliente(int id) {
		return clientesById.get(new Integer(id));
	}
	public Produto selectProduto(int id) {
		return produtosById.get(new Integer(id));
	}
	public void processarPagamento(Cliente cliente, double valor) {
		System.out.println("(Pagamento processado) Cliente: " + cliente.getId() + ", Valor: " + valor);
	}
	public void registrarCliente(Cliente cliente) {
		clientesById.put(cliente.getId(), cliente);
	}
	@Override
	public void receiveMessageCallback(Object o) {
		registrarCliente((Cliente) o);
	}
	
}