package Mercado;

import Infraestrutura.IBancoDados;
import Infraestrutura.IMercado;

public class MercadoFacade implements IMercado {
	private static MercadoFacade    _theFacade = null;
	
	private Mercado mercado_;
	private MercadoFacade() {
		mercado_ = new Mercado("Banco");
	}
	
	public static MercadoFacade    getInstance() {
		if (_theFacade == null) {
			_theFacade = new MercadoFacade();
		}
	        	return _theFacade;       
	   	 }
	
	public void registraComprador(String name, int id) {
			mercado_.registraComprador(name, id);
		}
		// realizar uma compra
	public void compra(int cliId, int prodId) {
		mercado_.compra(cliId, prodId);
	}
		// fechar compra
	public double fecharCompra(int cliId) {
		return mercado_.fecharCompra(cliId);
	}

	@Override
	public int registraNovoCliente(String nome, int id) {
		registraComprador(nome, id);
		return id;
	}

	@Override
	public void adicionaProduto(int idCliente, int idProduto) {
		compra(idCliente, idProduto);
	}

	@Override
	public void processarPagamento(int idCliente) {
		fecharCompra(idCliente);
	}

	@Override
	public IBancoDados setIBanco(String nomebanco) {
		return mercado_.setBanco(nomebanco);
	}
		
}//MercadoFacade

