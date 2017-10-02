package Q4.refatorado1;

import java.util.LinkedList;

// Novas responsabilidades de acordo com o ITEM C
public class SistemaOperacional {
	private LinkedList<Imprime> _impressoras = new LinkedList<>();
	
	public SistemaOperacional(Imprime impressoraPadrao) {
		_impressoras.add(impressoraPadrao);
	}
	
	public Imprime getImpressoraPadrao() {
		return _impressoras.peek();
	}
	
	public void adicionaImpressora(Imprime impressora) {
		_impressoras.add(impressora);
	}
	
	public void removeTodasImpressoras() {
		_impressoras.clear();
	}
	
	public Imprime[] getDriverImpressoraDisponiveis() {
		return (Imprime[]) _impressoras.toArray(); // Impressoras são imutáveis
	}
	
	public boolean isImpressoraValida(Imprime impressora) {
		return _impressoras.contains(impressora);
	}
}
