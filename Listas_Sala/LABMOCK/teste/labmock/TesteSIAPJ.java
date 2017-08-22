package labmock;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteSIAPJ {
	
	// Refatorei utilizando as anotações, antes tinha criado os objetos
	// no próprio método.
	// @InjectMocks private 
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso procValMock;
	@Mock private IProcesso procMock;
	
	@InjectMocks private ServicoDB dbInjetado; // Mudado para o teste com a implementação
	@Mock private Connection con;
	@Mock private Statement est;
	
	private SIAPJ objTeste;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objTeste = new SIAPJ(emailMock, dbMock, procValMock);
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(objTeste);
	}
	
	
	@Test
	public void QuandoValidaProcessoPersisteProcessoEEnviaEmailAceito() throws SQLException {
		Mockito.when(procValMock.validaProcesso(procMock)).thenReturn(true);
		Mockito.when(emailMock.sendEmail(procMock.getEmail(), "Processo aceito")).thenReturn(true);
		Mockito.when(procMock.getEmail()).thenReturn("meuEmail");
		
		objTeste.criaReclamacao(procMock);
		
		Mockito.verify(procValMock, Mockito.times(1)).validaProcesso(procMock);
		Mockito.verify(dbMock, Mockito.times(1)).persisteProcesso(procMock);
		Mockito.verify(emailMock, Mockito.times(1)).sendEmail("meuEmail", "Processo aceito");
	}
	
	
	@Test
	public void QuandoValidaProcessoEnviaEmailProcessoNaoAceito() throws SQLException {
		Mockito.when(procValMock.validaProcesso(procMock)).thenReturn(false);
		Mockito.when(emailMock.sendEmail(procMock.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		Mockito.when(procMock.getEmail()).thenReturn("meuEmail");
		
		objTeste.criaReclamacao(procMock);
		
		Mockito.verify(procValMock, Mockito.times(1)).validaProcesso(procMock);
		Mockito.verify(dbMock, Mockito.times(0)).persisteProcesso(procMock);
		Mockito.verify(emailMock, Mockito.times(1)).sendEmail("meuEmail", "Existem erros em seu processo");
	}
	
	@Test
	public void QuandoValidaProcessoExecutaStatement() throws SQLException {
		objTeste = new SIAPJ(emailMock, dbInjetado, procValMock);
		Mockito.when(procValMock.validaProcesso(procMock)).thenReturn(true);
		Mockito.when(emailMock.sendEmail(procMock.getEmail(), "Processo aceito")).thenReturn(true);
		Mockito.when(procMock.getEmail()).thenReturn("meuEmail");
		Mockito.when(con.createStatement()).thenReturn(est);
		
		objTeste.criaReclamacao(procMock);
		
		Mockito.verify(procValMock, Mockito.times(1)).validaProcesso(procMock);
		Mockito.verify(con, Mockito.times(1)).createStatement();
		Mockito.verify(est, Mockito.times(1)).executeUpdate(Mockito.any());
		Mockito.verify(emailMock, Mockito.times(1)).sendEmail("meuEmail", "Processo aceito");
	}

}
