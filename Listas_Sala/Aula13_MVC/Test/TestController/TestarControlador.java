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
import ref0.view.PersonDetailView;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe que testa o controlador
 */
public class TestarControlador {

	@InjectMocks private PersonDetailControllerImpl _control;
	@Mock private Person mockPerson;
	@Mock private PersonDetailView mockView;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void EhPossivelInstanciarController() {
		_control = new PersonDetailControllerImpl(mockPerson);
	}
	
	@Test
	public void TestarButtonPressed() {
		
		Mockito.when(mockView.getNameFromTextField()).thenReturn("NewName");
		_control = new PersonDetailControllerImpl(mockPerson);
		_control.changedButtonPressed();
		
		Mockito.verify(mockView, Mockito.times(1)).getNameFromTextField();
	}
}
