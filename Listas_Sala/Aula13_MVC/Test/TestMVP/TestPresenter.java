/**
 *  @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 *  Data: 31/10/2017
 */
package TestMVP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mvp.IPersonDetailView;
import mvp.Person;
import mvp.PersonPresenter;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 *
 */
public class TestPresenter {

	@Mock private Person _mockPerson;
	@Mock private IPersonDetailView _mockView;
	private PersonPresenter _presenter;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		_presenter = new PersonPresenter(_mockPerson,_mockView);
	}

	@Test
	public void EhPossivelInstanciarPresenter() {
		assertNotNull(_presenter);
	}

}
