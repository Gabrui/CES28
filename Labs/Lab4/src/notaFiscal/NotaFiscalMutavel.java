/**
 * 
 */
package notaFiscal;

import bancoDados.BD;
import bancoDados.Imposto;
import bancoDados.VerificadorCPF;

/**
 * @author Dylan N. Sugimoto
 *
 */
public class NotaFiscalMutavel extends NotaFiscal{

	private String _estado;
	public NotaFiscalMutavel(BD bancoRemoto, VerificadorCPF verificador, String CPF, String item, int quant) {
		super(bancoRemoto, verificador, CPF, item, quant);
		// TODO Auto-generated constructor stub
		_estado = "Em elaboracao";//Requisito 6
	}
    
	//Requisito 13. Metodo apropriado de modificacao da lista
	@Override //Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	public void adicionaItem(String item, int quant) {
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
	
	//Requisito 6. Somente NotaFiscal em elaboracao pode alterar lista de ItemVenda
	//Requisito 13. Metodo apropriado de modificacao da lista
	@SuppressWarnings("unlikely-arg-type")
	public void deletaItem(String nomeItem) {
		if (listaItens.contains(nomeItem)) {
			if (listaItens.size() == 1)
				throw new IllegalArgumentException("A lista não pode ficar vazia.");
			listaItens.remove(nomeItem);
		}
	}
	
	//DP visitor Requisito 10
	public void accept(Imposto imp) {
		for(ItemVenda i:listaItens) {
			i.accept(imp);
		}
		imp.taxar(this);
	}
}
