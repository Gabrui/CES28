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
			String[] delimitadores = delimitacao.split("\\]\\[");
			// Verifica o perigo de delimitadores contidos em outros delimitadores
			String[] ambiguos = null;
			if (existeAmbiguidade(delimitadores)) {
				ambiguos = delimitadoresAmbiguos(delimitadores);
				delimitadores = delimitadoresNaoAmbiguos(delimitadores);
			}
			for (String delimitador : delimitadores)
				operandos = operandos.replace(delimitador, ",");
			if (ambiguos != null) {
				String regexAmbiguos = gerarRegexAmbiguos(ambiguos);
				if (ehValidavel(operandos, regexAmbiguos))
					operandos = forcarValidacao(operandos);
			}
		}
		return somaStringNumerosSeparadosPadrao(operandos);
	}

	// Esse monte de método privado foi criado para contornar o problema da ambiguidade
	// de quando um delimitador está contido no outro e tem que encontrar uma fatoração.
	private static String forcarValidacao(String operandos) {
		// TODO inseguro para -
		return operandos.replaceAll("[^0-9- ]", " ").replaceAll("-+ ", " ").replaceAll("-+", "-");
	}

	private static boolean ehValidavel(String operandos, String regexAmbiguos) {
		return operandos.matches("( |,|\n|-\\d+|[0-9]|"+regexAmbiguos+")*");
	}

	private static String gerarRegexAmbiguos(String[] ambiguos) {
		// TODO validação de escape de regex
		String retorno = "";
		for (String s : ambiguos) {
			retorno += "|"+escaparUnicode(s);
		}
		return retorno.substring(1);
	}

	private static String escaparUnicode(String s) {
		String resp = "";
		for (int i=0; i<s.length(); i++) {
			resp += "\\u"+String.format("%04X", (int) s.charAt(i));
		}
		return resp;
	}

	private static String[] delimitadoresAmbiguos(String[] delimitadores) {
		boolean[] ambiguo = ehAmbiguo(delimitadores);
		int quant = 0;
		for (int i = 0; i < ambiguo.length; i++)
			if (ambiguo[i])
				quant++;
		String[] retorno = new String[quant];
		for (int i = 0, j =0; i < ambiguo.length; i++)
			if (ambiguo[i])
				retorno[j++] = delimitadores[i];
		return retorno;
	}

	private static String[] delimitadoresNaoAmbiguos(String[] delimitadores) {
		boolean[] ambiguo = ehAmbiguo(delimitadores);
		int quant = 0;
		for (int i = 0; i < ambiguo.length; i++)
			if (!ambiguo[i])
				quant++;
		String[] retorno = new String[quant];
		for (int i = 0, j =0; i < ambiguo.length; i++)
			if (!ambiguo[i])
				retorno[j++] = delimitadores[i];
		return retorno;
	}

	private static boolean existeAmbiguidade(String[] delimitadores) {
		if (delimitadores == null)
			throw new IllegalArgumentException();
		boolean[] ambiguo = ehAmbiguo(delimitadores);
		for (boolean b : ambiguo)
			if (b)
				return true;
		return false;
	}

	private static boolean[] ehAmbiguo(String[] delimitadores) {
		boolean[] ambiguo = new boolean[delimitadores.length];
		for (int i = 0; i<delimitadores.length; i++) {
			if (delimitadores[i].contains("]") || delimitadores[i].contains("[") ||
					delimitadores[i].matches(".*\\d+.*")) // Não tratável
				throw new IllegalArgumentException();
			for (int j = i+1; j<delimitadores.length; j++) {
				if (delimitadores[i].contains(delimitadores[j]) ||
					delimitadores[j].contains(delimitadores[i])) {
					ambiguo[i] = true;
					ambiguo[j] = true;
				}
			}
		}
		return ambiguo;
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
	
	/**
	 * 
	 */
	//public static 

}
