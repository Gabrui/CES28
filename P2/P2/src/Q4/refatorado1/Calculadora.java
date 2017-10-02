package Q4.refatorado1;

import java.util.Iterator;

public class Calculadora {

	public float calculaDespesas(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
		}
		return totalDespesa;
	}
	
}
