package utm_v1;


import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.DroneConcreto;
import utm_v0.model.EscutadorDrones;

public class TesteDrone {
	private DroneAbstrato drone;
	private @Mock EscutadorDrones escutador;
	
	@Before
	/**
	 * Inicializa os Mocks e o objeto a ser testado
	 */
	public void iniciaTeste() {
		MockitoAnnotations.initMocks(this);
		drone = new DroneConcreto(escutador, 13, "Drone Teste"); //Mockito.spy(DroneAbstrato.class);// 
	}

	@Test
	/**
	 * Verifica se a inicialização funcionou
	 */
	public void testaInicializacao() {
		assertNotNull(drone);
	}
	
	@Test
	/**
	 * Verifica se o drone está se registrando perante o Escutador de Drones
	 */
	public void testaRegistroDrone() {
		Mockito.verify(escutador, Mockito.times(1)).registraDrone(drone);
	}

	
	@Test
	/**
	 * Verifica a existência das informações de voo do drone
	 */
	public void testaInformacoesVoo() {
		assertNotNull(drone.getInformacoesVoo());
	}
	
	@Test
	/**
	 * Verifica se o drone está enviando as informações de voo corretamente ao escutador
	 */
	public void testaEnvioInformacoes() {
		drone.enviaInformacoesVoo();
		Mockito.verify(escutador, Mockito.times(2)).recebeAtualizacao(Mockito.any(), Mockito.any());
	}

}
