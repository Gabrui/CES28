package q4;

import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.junit.Before;
import org.junit.Test;

public class TestaControladorPTC {
	// Poderia ter usado as anotations, mas iniciei no setUp mesmo
	Sensor sensor;
	Datacenter dataCenter;
	PainelCondutor painelCond;
	ControladorPTC controlador;

	// a) Teste a inicialização do objeto ControladorPTC. (1.0 PT).
	// Utilizo dummys objects para testar a sua inicialização
	@Before
	public void setUp() {
		sensor = Mockito.mock(Sensor.class);
		dataCenter = Mockito.mock(Datacenter.class);
		painelCond = Mockito.mock(PainelCondutor.class);
		controlador = new ControladorPTC(sensor, dataCenter, painelCond);
	}

	
	// a) Teste a inicialização do objeto ControladorPTC. (1.0 PT).
	// Utilizo dummys objects para testar a sua inicialização
	@Test
	public void ItemA_TestaInicializacao() {
		// Refatorei o código daqui para o setUp
		assertNotNull(controlador);
	}
	
	
	// b) Construa um caso de teste, quando o trem não se encontra em um cruzamento,
	// Utilizo um Stub para o sensor
	@Test
	public void ItemB_QuandoNaoEstaNoCruzamentoEnviaMsgDatacenterPainelNormal() {
		// Enlata a resposta do stub
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		Mockito.when(sensor.getVelocidade()).thenReturn(55.0);
		controlador.run();
		
		// Verifica se a mensagem chegou no datacenter
		Mockito.verify(dataCenter, Mockito.times(1)).gerarRelatorio(Mockito.eq("55.0"));
		
		// Verifica se o painel está normal: aviso com prioridade IGUAL a 1
		Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso(Mockito.eq("55.0"), Mockito.eq(1));
	}
	
	
	// c) Construa um caso de teste, quando o trem se encontra em um cruzamento e a velocidade é superior 100Km/h
	// Utilizo um Stub para o sensor
	@Test
	public void ItemC_QuandoEstaNoCruzamentoComVelocidadeSuperior100() {
		// Enlata a resposta do stub
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(120.0);
		
		// Configura o comportamento do painel
		Mockito.when(painelCond.imprimirAviso(Mockito.anyString(), Mockito.anyInt())).thenReturn(true);
		
		controlador.run();
		
		// Verifica se o painel está normal: aviso com prioridade IGUAL a 2
		Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso(Mockito.eq("Velocidade alta"), Mockito.eq(2));
	}
	
	
	// d) Construa um caso de teste, quando o trem se encontra em um cruzamento e a velocidade é inferior a 20Km/h
	@Test
	public void ItemD_QuandoEstaNoCruzamentoComVelocidadeInferior20() {
		// Enlata a resposta do stub
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(10.0);
		
		// Configura o comportamento do painel
		//Mockito.when(painelCond.imprimirAviso(Mockito.any(), Mockito.any())).thenReturn(false);
		
		//controlador.run();
		
		// Verifica se o painel está normal: aviso com prioridade IGUAL a 1
		//Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso(Mockito.eq("120"), Mockito.eq(1));
	}

}
