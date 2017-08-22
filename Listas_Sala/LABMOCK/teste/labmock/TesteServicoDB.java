package labmock;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteServicoDB {
	
	@InjectMocks private ServicoDB obj;
	@Mock private Connection conecMock;
	@Mock private Statement est;
	@Mock private IProcesso procMock;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void inicializaServico() {
		assertNotNull(obj);
	}
	
	@Test
	public void inicializaConecao() throws SQLException {
		Mockito.when(conecMock.createStatement()).thenReturn(est);
		
		obj.persisteProcesso(procMock);
		
		Mockito.verify(conecMock, Mockito.times(1)).createStatement();
		Mockito.verify(est, Mockito.times(1)).executeUpdate(Mockito.any());
	}

}
