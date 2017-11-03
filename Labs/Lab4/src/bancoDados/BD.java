package bancoDados;

import java.util.List;

public interface BD {
	public ProdutoServico getProdutoServico(String nome);
	public Cliente getCliente(String CPF);
    String categoriaPS(ProdutoServico ps);//BD sabe a categoria de cada P/S
    int calculaImposto(ProdutoServico ps);//BD calcula o imposto de cada P/S
    void storeEstado(ProdutoServico ps);//BD guarda o estado de cada P/S para taxar.
    Imposto getRegra(String categoria);//BD sabe todas as regras de imposto.
    DataObject getDadosPS(ProdutoServico ps);//BD guarda os dados de todos P/S.
}
