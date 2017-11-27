package utm_v1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import utm_v0.presenter.SistemaMapas;
import utm_v0.presenter.UTMAbstrata;
import utm_v0.view.GCSAbstrata;
import utm_v0.view.GCSConcreta;


public class TesteGCS {
	private GCSAbstrata gcs;
	@Mock UTMAbstrata utm;
	
	@Before	
	/**
	 * Inicializa os Mocks e o objeto a ser testado
	 */
	public void iniciaTeste() {
		MockitoAnnotations.initMocks(this);
		gcs = new GCSConcreta(utm, "Teste");
	}

	@Test
	/**
	 * Verifica se a inicialização funcionou
	 */
	public void testaInicializacao() {
		assertNotNull(gcs);
	}
	
	@Test
	/**
	 * Verifica se o GCS se cadastrou perante o UTM (padrão Observer funcionando)
	 */
	public void verificaSeCadastrouGSM() {
		Mockito.verify(utm).addObserver(gcs);
	}
	
	@Test
	/**
	 * Verifica se o GCS está de fato atualizando os seus mapas quando recebe um update.
	 */
	public void verificaAtualizacaoMapasQuandoUpdate() {
		SistemaMapas mapa = Mockito.mock(SistemaMapas.class);
		gcs.update(utm, mapa);
		assertEquals(mapa, gcs.getMapasAtualizados());
	}

}
