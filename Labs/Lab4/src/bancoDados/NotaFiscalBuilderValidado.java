package bancoDados;

import java.util.HashMap;

import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalBuilderValidado extends NotaFiscalBuilder {

	public NotaFiscalBuilderValidado(NotaFiscalBuilder b, int ID, HashMap<String, Integer> taxasCobradas) {
		super(b.getBD());
		super.listaItens = b.getListaItens();
		super.validacaoAceita();
		super.setID(ID);
		super.setTaxasCobradas(taxasCobradas);
	}

}
