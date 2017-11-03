package notaFiscal;

import bancoDados.BD;
import bancoDados.VerificadorCPF;

public class NotaFiscalImutavel extends NotaFiscal{

	private int _ID;
	public NotaFiscalImutavel(BD bancoRemoto, VerificadorCPF verificador, String CPF, String item, int quant,int id) {
		super(bancoRemoto, verificador, CPF, item, quant);
		// TODO Auto-generated constructor stub
		_ID = id;
	}

	
}
