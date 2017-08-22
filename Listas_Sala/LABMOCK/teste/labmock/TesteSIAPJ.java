package labmock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TesteSIAPJ {
	
	// Refatorei utilizando as anotações, antes tinha criado os objetos
	// no próprio método.
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso procValMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testaConstrutor() {
		SIAPJ objTeste = new SIAPJ(emailMock, dbMock, procValMock);
		assertNotNull(objTeste);
	}

}
