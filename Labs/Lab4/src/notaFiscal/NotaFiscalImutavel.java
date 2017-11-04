package notaFiscal;

import java.util.HashMap;

import bancoDados.BD;
import bancoDados.VerificadorCPF;

//Requisito 16. NotaFiscalImutavel não possui metodos publicos de modificacao de seus
//atributos. Imutable Object.
public class NotaFiscalImutavel extends NotaFiscal{

	private int _ID; //Possui um id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
	private HashMap<String, Integer> _taxasCobradas;//Requisito 8. NotaFiscal sabe dos impostos cobrados.
	
	public NotaFiscalImutavel(BD bancoRemoto, VerificadorCPF verificador, String CPF, String item, int quant,int id,HashMap<String, Integer> ImpostosCobrados) {
		super(bancoRemoto, verificador, CPF, item, quant);
		// TODO Auto-generated constructor stub
		_ID = id;//id unico que é um inteiro sequencial dado pelo BD (Requisito 7).
		_taxasCobradas = ImpostosCobrados;//BD passa para NotaFiscal quais impostos e seus valores foram cobrados. (Requisito 8)
	}
	
    //Metodo de acesso para o id. Como é um int nao há risco de modificacao por agente externo.
	public int id() {
		return _ID;
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
