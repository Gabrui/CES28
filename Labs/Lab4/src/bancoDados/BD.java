package bancoDados;


import notaFiscal.NotaFiscalMutavel;
import notaFiscal.NotaFiscalImutavel;

public interface BD {
	
	public ProdutoServico getProdutoServico(String nome);
	public Cliente getCliente(String CPF);
	
    String categoriaPS(ProdutoServico ps);//BD sabe a categoria de cada P/S (Requisito 5)
    int calculaImposto(ProdutoServico ps);//BD calcula o imposto de cada P/S
    void storeEstado(ProdutoServico ps);//BD guarda o estado de cada P/S para taxar.
    Imposto getRegra(String categoria);//BD sabe todas as regras de imposto.
    DataObject getDadosPS(ProdutoServico ps);//BD guarda os dados de todos P/S. (Requisito 5)
    
    NotaFiscalImutavel validaNotaFiscal(NotaFiscalMutavel nota);//BD valida NotaFiscal
    //e submete na prefeitura, e se validada retorna NotaFiscalImutavel (Requisito 6)
}
