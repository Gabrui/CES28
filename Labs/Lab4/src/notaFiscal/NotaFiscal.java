/**
 * Codificação UTF-8
 * Gabriel Adriano
 * Dylan Sugimoto
 */

package notaFiscal;

import java.util.LinkedList;
import bancoDados.*;

public class NotaFiscal {
	
	protected LinkedList<ItemVenda> listaItens;
	protected BD bancoRemoto;
	protected Cliente comprador; //NotaFiscal tem os dados do cliente
	protected String _dataEntrega; //NotaFiscal sabe a data de entrega
	protected String _cEntrada; //NotaFiscal sabe as condicoes de entrega
	
	public NotaFiscal(BD bancoRemoto, VerificadorCPF verificador, 
			String CPF, String item, int quant) {
		this.bancoRemoto = bancoRemoto;
		this.comprador = bancoRemoto.getCliente(CPF);
		if (comprador == null)
			throw new IllegalArgumentException("Cliente não cadastrado no sistema.");
		if (!verificador.validaCPF(comprador.getCPF()))
			throw new IllegalArgumentException("CPF não é válido!");
		listaItens = new LinkedList<>();
		adicionaItem(item, quant);
	}
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	protected void adicionaItem(String item, int quant) {
		if (quant <= 0)
			throw new IllegalArgumentException("A quantidade não pode ser nula ou negativa.");
		listaItens.add(new ItemVenda(bancoRemoto, item, quant)); 
		//Se o P/S nao existir o BD deve lancar uma excecao.
		//Logo, NotaFiscal sempre tem pelo menos um item de venda (Requisito 1).
		//ItemVenda recebe P/S do BD. Só o BD cria P/S.
		//Todo Item de Venda é criado dentro da NotaFiscal na hora de adicionar
		//E o construtor de Item de Venda é protected compartilhando a mesma pkg que NotaFiscal
		//Logo, Cada Item de venda pertence apenas a uma NotaFiscal.
	}
	public int getValor() {
		int valor = 0;
		for (ItemVenda i : listaItens)
			valor += i.getValor();
		return valor;
	}
	
	/*public void deletaItem(String nomeItem) {
		ItemVenda item = new ItemVenda(bancoRemoto, nomeItem, 0);
		if (listaItens.contains(item)) {
			if (listaItens.size() == 1)
				throw new IllegalArgumentException("A lista não pode ficar vazia.");
			listaItens.remove(item);
		}
	}*/
	
	/**
	 * Retorna a quantidade de um item
	 * @param nomeItem
	 * @return A quantidade de produtos de um item
	 */
	public int getQuantidade(String nomeItem) {
		ItemVenda item = new ItemVenda(bancoRemoto, nomeItem, 0);
		for (ItemVenda i : listaItens)
			if (i.equals(item))
				return i.getQuantidade();
		return 0;
	}
}
