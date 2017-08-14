package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		int total = 0;
		String[] numeros = operandos.split("[, \n]");
		for(String numero : numeros) {
			total += CalculadoraString.getValor(numero);
		}
		return total;
	}
	
	private static int getValor(String numero) {
		if (numero.isEmpty())
			return 0;
		return Integer.valueOf(numero);
	}

}
