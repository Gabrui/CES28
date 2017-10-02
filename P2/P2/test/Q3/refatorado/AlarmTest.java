package Q3.refatorado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AlarmTest {
	
	@Mock ISensor sensor;
	Alarm alarme;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		alarme = new Alarm(sensor); // Código repetido refatorado aqui
	}

	@Test
	public void testaConstrutorAlarme() {
		assertNotNull(alarme); // É passado um dummy para o alarm em sua construção
	}
	
	@Test
	public void alarmeComecaDesligado() {
		assertFalse(alarme.isAlarmOn());
	}
	
	@Test
	public void alarmeDisparaParaPressaoPequena() {
		// Utilizo um Stub, com uma resposta enlatada
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(12.0);
		alarme.check();
		assertTrue(alarme.isAlarmOn());
	}
	
	@Test
	public void alarmeDisparaParaPressaoGrande() {
		// Utilizo um Stub, com uma resposta enlatada
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		alarme.check();
		assertTrue(alarme.isAlarmOn());
	}
	

	@Test
	public void alarmeConsultaSensorQuandoFazCheck() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		alarme.check();
		// Utilizo um Mock de sensor, pois verifico o seu comportamento.
		Mockito.verify(sensor, Mockito.times(1)).popNextPressurePsiValue();
	}
	
	@Test
	public void alarmeNaoDisparaQuandoPressaoEstaPadrao() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
		alarme.check();
		assertFalse(alarme.isAlarmOn());
	}
	
	@Test
	public void alarmeEhDesativadoQuandoDesativa() {
		Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		alarme.check();
		alarme.turnOffAlarm();
		assertFalse(alarme.isAlarmOn());
	}

}
