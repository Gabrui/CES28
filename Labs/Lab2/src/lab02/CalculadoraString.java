package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		
		if (operandos.startsWith("//")) {
			String delimitacao = "";
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
			for (String delimitador : delimitacao.split("\\]\\["))
				operandos = operandos.replace(delimitador, ",");
		}
		return somaStringNumerosSeparadosPadrao(operandos);
	}

	/**
	 * Opera de acordo com as regras, recebendo apenas a string de operandos
	 * separados por vírgulas, espaço ou \n. Lança os erros como previsto
	 * @throws IllegalArgumentException No caso de ser mal-formatada ou haver
	 * 		   números negativos.
	 * @param operandos String com números separados apenas por vírgulas
	 * @return O resultado da adição dos números.
	 */
	public static int somaStringNumerosSeparadosPadrao(String operandos) {
		String[] numeros = operandos.split(",| |\n");
		String erros = "";
		int total = 0;
		for(String numero : numeros) {
			try {
				total += CalculadoraString.transformaStringEmNumero(numero);
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
	
	/**
	 * Transforma uma string em número, de acordo com as regras do lab.
	 * @throws IllegalArgumentException A mensagem é o número negativo.
	 * @throws NumberFormatException Se não for um número.
	 * @param numero A string a ser convertida em número
	 * @return Um inteiro que representa o número
	 */
	public static int transformaStringEmNumero(String numero) {
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
