package notaFiscal;

import db.*;
import java.util.LinkedList;

public class NotaFiscal {
	
	private LinkedList<ItemVenda> listaItens;
	
	public NotaFiscal(Cadastro Cad, String CPF, String item, int quant) {
		listaItens = new LinkedList<>();
		adicionaItem(item, quant);
	}
	
	public void adicionaItem(String item, int quant) {
		listaItens.add(new ItemVenda(item, quant));
	}
}
