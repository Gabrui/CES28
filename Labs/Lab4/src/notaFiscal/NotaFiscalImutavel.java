package notaFiscal;

import java.util.HashMap;

import bancoDados.BD;
import bancoDados.VerificadorCPF;

public class NotaFiscalImutavel extends NotaFiscal{

	private int _ID; //Possui um id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
	private HashMap<String, Integer> _taxasCobradas;//Requisito 8. NotaFiscal sabe dos impostos cobrados.
	
	public NotaFiscalImutavel(BD bancoRemoto, VerificadorCPF verificador, String CPF, String item, int quant,int id,HashMap<String, Integer> ImpostosCobrados) {
		super(bancoRemoto, verificador, CPF, item, quant);
		// TODO Auto-generated constructor stub
		_ID = id;//id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
		_taxasCobradas = ImpostosCobrados;//BD passa para NotaFiscal quais impostos e seus valores foram cobrados. (Requisito 8)
	}
	//Requisito 8. NotaFiscal sabe dos impostos cobrados e sabe o valor deles.
	public int valorCobradoImposto(String nomeImposto) {
		
		return _taxasCobradas.get(nomeImposto);
	}
	//Requisito 8. NotaFiscal sabe dos impostos cobrados e sabe imprimir eles.
	public void imprimirImpostoCobrado() {
		
		System.out.println("Impostos cobrados: ");
		for (String key : _taxasCobradas.keySet())
			System.out.print("\n     "+key+_taxasCobradas.get(key).toString());
	}
}
