package db;

/**
 * Faz a conexão remota com o banco de dados
 */
public interface BDCliente {
	Cliente getCliente(String CPF);
}
