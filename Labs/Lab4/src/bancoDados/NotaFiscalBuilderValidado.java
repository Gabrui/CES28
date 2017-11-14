package bancoDados;

import notaFiscal.NotaFiscalBuilder;

public class NotaFiscalBuilderValidado extends NotaFiscalBuilder {

	public NotaFiscalBuilderValidado(NotaFiscalBuilder b, int ID) {
		super(b.getBD());
		super.listaItens = b.getListaItens();
		super.setTaxaTotal(b.getTaxaTotal());
		super._taxasCobradas = b.getTaxasCobradas();
		super.validacaoAceita();
		super.setID(ID);
	}
	 

}
