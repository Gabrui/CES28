package bancoDados;

public interface VerificadorCPF {
	/**
	 * @param CPF
	 * @return Verdadeiro quando está tudo certo.
	 */
	public boolean validaCPF(String CPF);
}
