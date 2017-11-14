package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import bancoDados.BDfake;
import notaFiscal.NotaFiscal;
import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalTesteTaxasSimples {
	
	BDfake bd;
	NotaFiscalBuilder NFB;
	NotaFiscalBuilder NFB2;
	NotaFiscalBuilder NFB3;
	NotaFiscal NF;
	NotaFiscal NF2;
	
	@Before
	public void setup() {
		bd = new BDfake();
		NFB = new NotaFiscalBuilder(bd);
		NFB2 = new NotaFiscalBuilder(bd);
		NFB3 = new NotaFiscalBuilder(bd);
		/*
		 * Nota Fiscal Builder 2 inicializa com alguns items de frutas
		 */
		NFB2.adicionaItem("banana", 1);
		NFB2.adicionaItem("pera", 1);
		NFB2.adicionaItem("laranja",1);
		/*
		 * Nota Fiscal Builder 3 inicializa com  eletronicos
		 */
		NFB3.adicionaItem("PC Gamer", 1);
		
		
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
	public void TestingTaxatingUponFruitsSimpleItems() {
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
	@Test
	public void TestingTaxatingUponSimpleCompositeItem() {
		/*
		 * aliquota = 5
		 * banana = 1
		 * pera = 2
		 * laranja = 3
		 * cesta_de_frutas = 1 pera + 1 banana + 1 laranja = 6
		 * 
		 * Taxa de NF = aliquota*(Preço total dos produtos)*(Numero atual de IVs taxados + Numero de IVs taxados anteriormente)
		 * NF2.taxa = 5*(1 + 2 + 3 + 6 )*(4 + 0) = 240
		 * 
		 * Detalhe que a cesta de frutas, apesar de conter 3 frutas, conta como um único IV
		 */
		NFB2.adicionaItem("cesta de frutas",1);
		NF2 = NFB2.valida();
		assertEquals(240,NF2.getTaxaTotal());
	}
	
	@Test
	public void TestingTaxatingUponCompositeItemContainingCompositeItem() {
		
	}
	
	@Test
	public void CantCreateProtectedObjects() {
		// Fail in compilation
		// Produto p = new Produto();
	}

}