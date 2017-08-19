package lab02;

public class CalculadoraString {

	public static int add(String operandos) {
		if (operandos.isEmpty())
			return 0;
		
		if (operandos.startsWith("//[")) {
			if (operandos.contains("[]"))
				throw new IllegalArgumentException();
			String delimitacao = "";
			String[] partes = operandos.split("\\]\n", 2);
			if (partes.length != 2)
				throw new IllegalArgumentException();
			delimitacao = partes[0];
			operandos = partes[1];
			try {
				delimitacao = delimitacao.substring(3);
			} catch (IndexOutOfBoundsException erro) {
				throw new IllegalArgumentException();
			}
			if (delimitacao.isEmpty())
				throw new IllegalArgumentException();
			for (String delimitador : delimitacao.split("\\]\\[")) {
				if (delimitador.contains("]") || delimitador.contains("[") ||
						delimitador.matches(".*\\d+.*")) // TODO contém dígito?
					throw new IllegalArgumentException();
				operandos = operandos.replace(delimitador, ",");
			}
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
		int valor;
		if (numero.length() > 7) { // Para verificar casos que dariam overflow
			if (numero.matches("\\d+") || numero.matches("-0+")) {
				try {
					valor =  Integer.valueOf(numero);
				} catch (NumberFormatException e) {
					return 0;
				}
			} else if (numero.matches("-\\d+"))
				throw new IllegalArgumentException(numero);
			else 
				throw new NumberFormatException();
		}
		valor =  Integer.valueOf(numero);
		if (valor > 1000)
			return 0;
		if (valor < 0)
			throw new IllegalArgumentException(numero);
		return valor;
	}

}
