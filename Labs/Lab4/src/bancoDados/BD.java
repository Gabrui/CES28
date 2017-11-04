package bancoDados;


import notaFiscal.NotaFiscalMutavel;

public interface BD {
	public static BD getInstance() {
		return null;
	}
	public ProdutoServico getProdutoServico(String nome);
	
    String categoriaPS(ProdutoServico ps);//BD sabe a categoria de cada P/S (Requisito 5)
    
    void storeEstado(ProdutoServico ps);//BD guarda o estado de cada P/S para taxar.
    
    DataObject getDadosPS(ProdutoServico ps);//BD guarda os dados de todos P/S. (Requisito 5)
    
    NotaFiscalImutavel validaNotaFiscal(NotaFiscalMutavel nota);//BD valida NotaFiscal
    //e submete na prefeitura, e se validada retorna NotaFiscalImutavel (Requisito 6)
    
    int calculaImposto(ProdutoServico ps);//BD calcula o imposto de cada P/S (Requisito 8)
    Imposto getRegra(String categoria);//BD sabe todas as regras de imposto. (Requisito 8)
}
