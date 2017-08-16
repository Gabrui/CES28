package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		int total = 0;
		String delimitacao = "";
		if (operandos.startsWith("//")) {
			String[] partes = operandos.split("\n", 2);
			if (partes.length != 2)
				throw new IllegalArgumentException();
			delimitacao = partes[0];
			operandos = partes[1];
			if (delimitacao.contains("[]") || !delimitacao.endsWith("]") || !delimitacao.startsWith("//["))
				throw new IllegalArgumentException();
			try {
				delimitacao = delimitacao.substring(3, partes[0].length()-1);
			} catch (IndexOutOfBoundsException erro) {
				throw new IllegalArgumentException();
			}
			if (delimitacao.isEmpty())
				throw new IllegalArgumentException();
			delimitacao = "|"+delimitacao.replace("][", "|");
			// TODO Marcadores especiais precisam ser escapados
			delimitacao = delimitacao.replace(".", "\\.");
		}
		String[] numeros = operandos.split(",| |\n"+delimitacao);
		String erros = "";
		for(String numero : numeros) {
			try {
				total += CalculadoraString.getValor(numero);
			} catch (NumberFormatException erro) {
				throw new IllegalArgumentException();
			} catch (IllegalArgumentException erro) {
				erros += " "+erro.getMessage();
			}
		}
		if (!erros.isEmpty()) {
			erros = "negativos proibidos ["+erros.substring(1) + "]";
			throw new IllegalArgumentException(erros);
		}
		return total;
	}
	
	private static int getValor(String numero) {
		if (numero.isEmpty())
			return 0;
		if (numero.length() > 5) {
			if (numero.matches("\\d+"))
				return 0;
			if (numero.matches("-\\d+"))
				throw new IllegalArgumentException(numero);
			throw new NumberFormatException();
		}
		int valor =  Integer.valueOf(numero);
		if (valor > 1000)
			return 0;
		if (valor < 0)
			throw new IllegalArgumentException(numero);
		return valor;
	}

}
