package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		int total = 0;
		if (operandos.startsWith("//")) {
			String[] partes = operandos.split("\n", 1);
			String delimitacao = partes[0].substring(2);
			if (partes.length !=2)
				return 0;
			operandos = partes[1];
		}
		
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
