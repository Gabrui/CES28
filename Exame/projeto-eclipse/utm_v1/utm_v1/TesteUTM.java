package utm_v1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.InformacaoVoo;
import utm_v0.presenter.SistemaMapas;
import utm_v0.presenter.UTMAbstrata;
import utm_v0.presenter.UTMConcreta;

public class TesteUTM {
	private UTMAbstrata utm;
	
	@Before
	/**
	 * Inicializa os Mocks e o objeto a ser testado
	 */
	public void iniciaTestes() {
		utm = UTMConcreta.getInstance(); // Singleton
	}

	@Test
	/**
	 * Verifica se realmente o padrão Singleton está funcionando
	 */
	public void testaInicializacao() {
		// utm = new UTMConcreta(); // Não compila, private
		assertNotNull(utm);
	}
	
	@Test
	/**
	 * Verifica se o sistema de mapas existe e é válido.
	 */
	public void testaSistemaMapas() {
		assertNotNull(utm.getSistemaMapas());
	}
	
	@Test
	/**
	 * Verifica se o registro funciona corretamente 
	 */
	public void testaRegistroEAtualizacao() {
		DroneAbstrato d = Mockito.mock(DroneAbstrato.class);
		SistemaMapas s = utm.getSistemaMapas();
		utm.registraDrone(d);
		utm.recebeAtualizacao(d, Mockito.mock(InformacaoVoo.class));
		assertEquals("Há 0 drones registrados.", s.getOutros());
		utm.atualizaInformacoes();
		s = utm.getSistemaMapas();
		assertEquals("Há 1 drones registrados.", s.getOutros());
	}

}
