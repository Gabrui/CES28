package Q4.refatorado1;

import java.util.Iterator;

public class RelatorioDespesas {
	
	public void imprimirRelatorio(float totalDespesa, Imprime impressora) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas: " + totalDespesa);

		impressora.imprimir(conteudo);
	}
	
	// Caso alguém reclame que queria passar um iterador
	public void imprimirRelatorio(Iterator<Despesa> despesas, Imprime impressora) {
		Calculadora calc = new Calculadora(); // Dependência OK para LoD
		imprimirRelatorio(calc.calculaDespesas(despesas), impressora);
	}
}