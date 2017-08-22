package labmock;

import static org.junit.Assert.*;

import java.beans.Statement;
import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TesteServicoDB {
	
	@InjectMocks private IServicoDB obj;
	@Mock private Connection conecMock;
	@Mock private Statement stateMock;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		obj = new ServicoDB();
	}
	

	@Test
	public void inicializaServico() {
		assertNotNull(obj);
	}
	
	@Test
	public void inicializaConecao() {
		
	}

}
