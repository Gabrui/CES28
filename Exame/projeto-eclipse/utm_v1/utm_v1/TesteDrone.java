package utm_v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.DroneConcreto;
import utm_v0.model.EscutadorDrones;

class TesteDrone {
	private DroneAbstrato drone;
	@Mock EscutadorDrones escutador;
	
	@Before
	void iniciaTeste() {
		MockitoAnnotations.initMocks(this);
		drone = new DroneConcreto(escutador);
	}

	@Test
	void testaInicializacao() {
		assertNotNull(drone);
	}

}
