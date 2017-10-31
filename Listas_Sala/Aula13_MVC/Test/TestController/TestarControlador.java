/**
 * 
 */
package TestController;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ref0.controller.*;
import ref0.model.Person;
import ref0.view.IPersonDetailView;
import ref0.view.PersonDetailView;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe que testa o controlador
 */
public class TestarControlador {

	@Mock private IPersonDetailView mockView;
	@Mock private Person mockPerson;
	@InjectMocks private PersonDetailControllerImpl _control;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		_control = new PersonDetailControllerImpl(mockPerson,mockView);
	}

	@Test
	public void EhPossivelInstanciarController() {
		
		assertNotNull(_control);
	}
	
	@Test
	public void TestarButtonPressed() {
		
		Mockito.when(mockView.getNameFromTextField()).thenReturn("NewName");
		_control.changedButtonPressed();
		
		Mockito.verify(mockView, Mockito.times(1)).getNameFromTextField();
		Mockito.verify(mockPerson, Mockito.times(1)).setName("NewName");
	}
}
