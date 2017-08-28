package notaFiscal;

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
	
	public int getValor() {
		int valor = 0;
		for (ItemVenda i : listaItens)
			valor += i.getValor();
		return valor;
	}
}
