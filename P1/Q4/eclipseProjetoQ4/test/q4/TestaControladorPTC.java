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
		
		controlador.run();
		
		// Verifica se a mensagem chegou no datacenter
		Mockito.verify(dataCenter, Mockito.times(1)).gerarRelatorio(Mockito.anyString());
		
		// Verifica se o painel está normal: aviso com prioridade IGUAL a 1
		Mockito.verify(painelCond, Mockito.times(1)).imprimirAviso(Mockito.anyString(), Mockito.eq(1));
	}

}
