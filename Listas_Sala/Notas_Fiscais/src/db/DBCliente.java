package db;

/**
 * Faz a conexão remota com o banco de dados
 */
interface DBCliente {
	/**
	 * @param CPF
	 * @return Um vetor com as informações do cliente, nome ...
	 */
	String[] getInformacoesCliente(String CPF);
	String getNomeCliente(String CPF);
}
