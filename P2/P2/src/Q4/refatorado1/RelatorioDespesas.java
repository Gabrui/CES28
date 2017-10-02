package Q4.refatorado1;

import java.util.Iterator;

public class RelatorioDespesas {
	
	public void imprimirRelatorio(float totalDespesa, Imprime impressora) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas: " + totalDespesa);

		impressora.imprimir(conteudo);
	}
	
	
	// ATENÇÃO, esse método aqui é um EXTRA:
	// Caso a resposta acima tenha ficado muito simples, e se desejasse passar um iterador
	// Eu fiz um Overload que satisfaça as necessidades de se usar obrigatoriamente um iterador.
	public void imprimirRelatorio(Iterator<Despesa> despesas, Imprime impressora) {
		Calculadora calc = new Calculadora(); // Dependência OK para LoD
		imprimirRelatorio(calc.calculaDespesas(despesas), impressora);
	}
	
}