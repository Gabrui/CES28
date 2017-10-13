package ex4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.Mockito;

public class FINALTesteFactoryFinal {

	
	private FactoryCarta _caneta;
	@Mock Pessoa _pessoaMockada;
	@Mock Data _dataMockada;
	@Mock Idioma _idiomaMockado;
	@Mock Ingles _inglesMockado;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		_caneta = new FactoryCarta(_pessoaMockada,_pessoaMockada,_dataMockada,_idiomaMockado);
	}

	@Test
<<<<<<< HEAD
	public void EhPossivelInstanciarFactoryCarta() {
		assertNotNull(_caneta);
	}
	@Test
	public void RetornaCartaQuandoPedeParaConstruirUmaCarta() {
		
		assertTrue(_caneta.buildCartaComercial() instanceof Carta);
		assertTrue(_caneta.buildCartaPessoal() instanceof Carta);
		assertTrue(_caneta.buildCartaArgumentativa() instanceof Carta);
=======
	public void test() {
		//fail("Not yet implemented");
>>>>>>> origin/master
	}

}
