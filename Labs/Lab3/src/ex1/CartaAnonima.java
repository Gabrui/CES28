package ex1;


/**
 * Carta anônima muito diferente das demais
 */
public class CartaAnonima extends Carta {

	public CartaAnonima(Pessoa destinatario, Data data) {
		super(new Pessoa.PessoaBuilder("Anônimo", new Endereco("", "", "", "")).build(), 
				destinatario, data);
	}
	
	@Override
	public String assinatura() {
		return "";
	}
	
	@Override
	protected String cabecalho() {
		return  _destinatario.getEndereco() + "\n" +_data.toString() + "\n\n";
	}
	
	@Override
	protected String conclusao() {
		return  "Obrigado.";
	}

}
