package labmock;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ServicoDB implements IServicoDB {
	
	private Connection conec;

	@Override
	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conec = DriverManager.getConnection("meudb", "admin", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int persisteProcesso(IProcesso proc) {
		String comando = "INSERT INTO Processos (Id, NomeReclamante, Telefone, Email)" 
				+ "VALUE ('"+proc.getID()+"', '"+proc.getNomeReclamante()+"', '"+proc.getTelefone()
				+ "', '"+ proc.getEmail()+"');";
		int valor = 0;
		try {
			Statement est = conec.createStatement();
			valor = est.executeUpdate(comando);
		} catch (Exception e) {};
		return valor;
	}

}
