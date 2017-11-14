package bancoDados;

import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalBuilderValidado extends NotaFiscalBuilder {

	public NotaFiscalBuilderValidado(NotaFiscalBuilder b, int ID) {
		super(b.getBD());
		super.listaItens = b.getListaItens();
		super.setTaxaTotal(b.getTaxaTotal());
		super.validacaoAceita();
		super.setID(ID);
	}
	 

}
