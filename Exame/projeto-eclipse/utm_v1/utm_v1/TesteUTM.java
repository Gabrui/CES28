package utm_v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import utm_v0.presenter.UTMAbstrata;
import utm_v0.presenter.UTMConcreta;

class TesteUTM {
	private UTMAbstrata utm;
	
	@Before
	void iniciaTestes() {
		utm = UTMConcreta.getInstance(); // Singleton
	}

	@Test
	/**
	 * Verifica se realmente o padrão Singleton está funcionando
	 */
	void testaInicializacao() {
		// utm = new UTMConcreta(); // Não compila, private
		assertNotNull(utm);
	}

}
