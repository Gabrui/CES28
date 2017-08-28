package notaFiscal;
import db.*;


public class Cadastro {

	private BDCliente bancoDadosRemoto;
	private VerificadorCPF spcRemoto;
	
	public Cadastro(BDCliente bancoDadosRemoto, VerificadorCPF spcRemoto) {
		this.bancoDadosRemoto = bancoDadosRemoto;
		this.spcRemoto = spcRemoto;
	}
	
	public Cliente getCliente(String CPF) {
		Cliente c = bancoDadosRemoto.getCliente(CPF);
		if (spcRemoto.validaCPF(CPF))
			return c;
		throw new IllegalArgumentException("O CPF não passou no SPC.");
	}

}
