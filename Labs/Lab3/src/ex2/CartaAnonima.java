package ex2;

/**
 * Carta anônima muito diferente das demais
 */
public class CartaAnonima extends Carta {

	public CartaAnonima(Pessoa destinatario, Data data, Idioma idioma) {
		super(new Pessoa.PessoaBuilder("Anônimo", new Endereco("", "", "", "")).build(), 
				destinatario, data, idioma);
	}
	
	@Override
	public String assinatura() {
		return "";
	}
	
	@Override
	protected String cabecalho() {
		return  _destinatario.getEndereco(_idioma) + "\n" +_idioma.data(_data) + "\n\n";
	}
	
	@Override
	protected String conclusao() {
		return  _idioma.despedida() + ".";
	}

}
