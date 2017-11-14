package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import bancoDados.BDfake;
import notaFiscal.NotaFiscal;
import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalTesteIVs {
	
	BDfake bd;
	NotaFiscalBuilder NFB;
	NotaFiscalBuilder NFB2;
	NotaFiscal NF;
	
	@Before
	public void setup() {
		bd = new BDfake();
		NFB = new NotaFiscalBuilder(bd);
		NFB2 = new NotaFiscalBuilder(bd);
		NFB2.adicionaItem("banana", 1);
		NFB2.adicionaItem("pera", 2);
		NFB2.adicionaItem("laranja", 5);
		
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
	public void TestingDeletingOnBuilderIfNUmberOfProductsAreHighterThanOne() {
		NFB2.deletaItem("pera");
		NF =  NFB2.buildEsboco();
		assertEquals("banana\nlaranja\n",NF.nomeItens());
	}

}
