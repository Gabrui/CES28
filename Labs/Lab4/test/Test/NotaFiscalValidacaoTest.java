package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import bancoDados.BDfake;
import notaFiscal.NotaFiscal;
import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalValidacaoTest {
	
	BDfake bd;
	NotaFiscalBuilder NFB;
	NotaFiscalBuilder NFB2;
	NotaFiscal NF;
	NotaFiscal NF2;
	
	@Before
	public void setup() {
		bd = new BDfake();
		NFB = new NotaFiscalBuilder(bd);
		NFB2 = new NotaFiscalBuilder(bd);
		NFB2.adicionaItem("banana", 1);
		NFB2.adicionaItem("pera", 1);
		NFB2.adicionaItem("laranja",1);
		
	}
	@Test
	public void TestingAddingItemsOnBuilder() {
		NFB.adicionaItem("banana", 1);
		NFB.adicionaItem("pera", 3);
		NF =  NFB.buildEsboco();
		assertEquals("banana\npera\n",NF.nomeItens());
	}
	@Test(expected = IllegalArgumentException.class)
	public void ItemAddedOnBuilderDoesNotExistOnBD_ExpectIllegalArgumentException() {
		NFB.adicionaItem("banana", 1);
		NFB.adicionaItem("pera", 3);
		NFB.adicionaItem("ps4", 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void BuilderShouldNotGenerateEmptyNFAsEsboco_ExpectIllegalArgumentExceptio() {
		NF = NFB.buildEsboco();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void BuilderShouldNotValidateEmptyNF_ExpectIllegalArgumentExceptio() {
		NF = NFB.valida();
	}
	
	@Test
	public void TestingTaxationgUponFruitsSimpleItems() {
		NFB.adicionaItem("banana", 1);
		NFB.adicionaItem("pera", 3);
		NFB.adicionaItem("laranja", 1);
		
		NF = NFB.valida();
		assertEquals(150,NF.getTaxaTotal());	
	}
	@Test
	public void TestingCumulativeTax_SameProductsDoesNotImplySameTax() {
		/*
		 * aliquota = 5
		 * banana = 1
		 * pera = 2
		 * laranja = 3
		 * 
		 * Taxa de NF = aliquota*(Preço total dos produtos)*(Numero atual de IVs taxados + Numero de IVs taxados anteriormente)
		 * NF.taxa = 5*(1 + 2 + 3 )*(3 + 0) = 90
		 * NF.taxa = 5*(1 + 2 + 3 )*(3 + 3) = 180
		 */
		NF = NFB2.valida();
		NF2 = NFB2.valida();
		
		assertEquals(90,NF.getTaxaTotal());
		assertEquals(180,NF2.getTaxaTotal());
	}
	
	

}