package labmock;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSIAPJ {

	@Test
	public void test() {
		IServicoEmail emailMock = mock(IServicoEmail.class);
		IServicoDB dbMock = mock(IServicoDB.class);
		IValidatorProcesso procValMock  = mock(IValidatorProcesso.class);
		SIAPJ objTeste = new SIAPJ(emailMock, dbMock, procValMock);
		assertNotNull(objTeste);
	}

}
