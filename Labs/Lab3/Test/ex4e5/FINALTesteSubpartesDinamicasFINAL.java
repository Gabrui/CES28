package ex4e5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * As subpartes dinâmicas estão representados pelo Idioma.
 * 
 * Para observar o seu uso conjunto com a Carta ou com a FactoryCarta,
 * observe o teste da Factory.
 *
 * Satisfaz o Ex4 sem o uso de Factory, pois todas as subpartes foram
 * agrupadas em uma única classe idioma, para que não houvessem Classes
 * Anêmicas. Assim, usou-se um FluentBuilder para a construção do novo
 * idioma e uma espécie de Strategy para as delegações entre idiomas.
 * 
 * Para o uso dos Idioma padrões, utilizou-se o padrão Singleton, uma
 * vez que, uma vez construídos, os idiomas são imutáveis.
 * 
 * O Builder faz uso de um Factory Method, internamente.
 * 
 * Os Idiomas são facilmente estendíveis, sendo fácil para um usuário
 * programador adicionar novos idiomas.
 *
 */
public class FINALTesteSubpartesDinamicasFINAL {
	
	private Idioma idioma;

	@Test
	public void testeIdiomaPadrao() {
		idioma = Ingles.INSTANCE;
		assertEquals("Gratefully", idioma.despedida());
		assertEquals("Mr.", idioma.pronome());
		assertEquals("Dear", idioma.vocativo());
		assertEquals("Mes/Dia/Ano", idioma.data("Dia", "Mes", "Ano"));
	}
	
	@Test
	public void testaIdiomaConfiguradoDinamicamente() {
		// Constrói um novo idioma baseado no inglês, 
		// mas cujo pronome e vocativo está em português
		idioma = new Idioma.Builder(Ingles.INSTANCE).pronome(Portugues.INSTANCE)
				.vocativo(Portugues.INSTANCE).build();
		
		assertEquals("Gratefully", idioma.despedida());
		assertEquals("Senhor", idioma.pronome()); // O pronome agora está em português!
		assertEquals("Caro", idioma.vocativo()); // O vocativo agora está em português!
		assertEquals("Mes/Dia/Ano", idioma.data("Dia", "Mes", "Ano"));
	}


	@Test
	public void testeIdiomaPadraoPortugues() {
		idioma = Portugues.INSTANCE;
		assertEquals("Atensiosamente", idioma.despedida());
		assertEquals("Senhor", idioma.pronome());
		assertEquals("Caro", idioma.vocativo());
		assertEquals("Dia de Mes de Ano", idioma.data("Dia", "Mes", "Ano"));
		assertEquals("Rua, Cidade, Estado - Pais", 
				idioma.endereco("Rua", "Cidade", "Estado", "Pais"));
	}
	
	@Test
	public void testaIdiomaConfiguradoDinamicamentePortugues() {
		// Constrói um novo idioma baseado no português, 
		// mas cujo pronome e vocativo está em inglês
		idioma = new Idioma.Builder(Portugues.INSTANCE).pronome(Ingles.INSTANCE)
				.vocativo(Ingles.INSTANCE).build();
		
		assertEquals("Atensiosamente", idioma.despedida());
		assertEquals("Mr.", idioma.pronome()); // O pronome agora está em inglês
		assertEquals("Dear", idioma.vocativo()); // O vocativo agora está em inglês
		assertEquals("Dia de Mes de Ano", idioma.data("Dia", "Mes", "Ano"));
		assertEquals("Rua, Cidade, Estado - Pais", 
				idioma.endereco("Rua", "Cidade", "Estado", "Pais"));
	}
}
