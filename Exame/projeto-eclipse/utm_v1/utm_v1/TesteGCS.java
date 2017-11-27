package utm_v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import utm_v0.presenter.UTMAbstrata;
import utm_v0.view.GCSAbstrata;
import utm_v0.view.GCSConcreta;


class TesteGCS {
	private GCSAbstrata gcs;
	@Mock UTMAbstrata utm;
	
	@Before
	void iniciaTeste() {
		MockitoAnnotations.initMocks(this);
		gcs = new GCSConcreta(utm, "Teste");
	}

	@Test
	void testaInicializacao() {
		assertNotNull(gcs);
	}

}
