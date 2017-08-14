package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		int total = 0;
		String delimitacao = "";
		if (operandos.startsWith("//")) {
			String[] partes = operandos.split("\n", 2);
			delimitacao = partes[0];
			operandos = partes[1];
			if (delimitacao.contains("[]"))
				throw new IllegalArgumentException();
			delimitacao = "|"+delimitacao.substring(3, partes[0].length()-1).replace("][", "|");
		}
		String[] numeros = operandos.split(",| |\n"+delimitacao);
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
