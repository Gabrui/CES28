package bancoDados;

import notaFiscal.NotaFiscalBuilder;

public interface BD {
	public static BD getInstance() {
		return null;
	}
	public ProdutoServico getProdutoServico(String nome);
	
    public NotaFiscalBuilderValidado validaNotaFiscal(NotaFiscalBuilder nota);//BD valida NotaFiscal
    //e submete na prefeitura, e se validada retorna NotaFiscalImutavel (Requisito 6)
    
    int calculaImposto(ProdutoServico ps);//BD calcula o imposto de cada P/S (Requisito 8)
    Imposto getRegra(String categoria);//BD sabe todas as regras de imposto. (Requisito 8)
}
