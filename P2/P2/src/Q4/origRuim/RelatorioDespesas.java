package Q4.origRuim;

import java.util.Iterator;

public class RelatorioDespesas {
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		Calculadora calculadora = new Calculadora ();
		float totalDespesa = calculadora.calculaDespesas(despesas);
	}
}