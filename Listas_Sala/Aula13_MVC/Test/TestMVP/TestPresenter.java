/**
 *  @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 *  Data: 31/10/2017
 */
package TestMVP;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	@Test
	public void TestPresenterUpdate() {
		Mockito.when(_mockPerson.getClassificacao()).thenReturn("curto");
		Mockito.when(_mockPerson.getName()).thenReturn("NewName");
		_presenter.update(_mockView, "NewName");
		
		Mockito.verify(_mockPerson, Mockito.times(1)).setName("NewName");
		Mockito.verify(_mockView, Mockito.times(1)).updateView(Color.RED,"NewName");
		
		Mockito.when(_mockPerson.getClassificacao()).thenReturn("medio");
		Mockito.when(_mockPerson.getName()).thenReturn("NewName");
		_presenter.update(_mockView, "NewName");
		
		Mockito.verify(_mockPerson, Mockito.times(2)).setName("NewName");
		Mockito.verify(_mockView, Mockito.times(1)).updateView(Color.GREEN,"NewName");
		
		Mockito.when(_mockPerson.getClassificacao()).thenReturn("longo");
		Mockito.when(_mockPerson.getName()).thenReturn("NewName");
		_presenter.update(_mockView, "NewName");
		
		Mockito.verify(_mockPerson, Mockito.times(3)).setName("NewName");
		Mockito.verify(_mockView, Mockito.times(1)).updateView(Color.YELLOW,"NewName");
		
		Mockito.when(_mockPerson.getClassificacao()).thenReturn("longo");
		Mockito.when(_mockPerson.getName()).thenReturn("NewName");
		_presenter.update(_mockView, "");
		
		Mockito.verify(_mockPerson, Mockito.times(1)).setName("");
		Mockito.verify(_mockView, Mockito.times(2)).updateView(Color.YELLOW,"NewName");
	}

}
