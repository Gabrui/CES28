package db;

/**
 * Faz a conexão remota com o banco de dados
 */
public interface BDCliente {
	/**
	 * @param CPF
	 * @return Um vetor com as informações do cliente, nome ...
	 */
	void conectarServidor(String Servidor);
	Cliente getCliente(String CPF);
}
