/**
 * 
 */
package notaFiscal;

import bancoDados.BD;
import bancoDados.VerificadorCPF;

/**
 * @author Dylan N. Sugimoto
 *
 */
public class NotaFiscalMutavel extends NotaFiscal{

	private String _estado;
	public NotaFiscalMutavel(BD bancoRemoto, VerificadorCPF verificador, String CPF, String item, int quant) {
		super(bancoRemoto, verificador, CPF, item, quant);
		// TODO Auto-generated constructor stub
		_estado = "Em elaboracao";
	}

	
}
