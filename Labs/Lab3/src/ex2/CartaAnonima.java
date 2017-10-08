package ex2;

public class CartaAnonima extends Carta {

	public CartaAnonima(Pessoa destinatario, Data data, Idioma idioma) {
		super(new Pessoa.PessoaBuilder().build(), destinatario, data, idioma);
	}
	
	@Override
	public String modelo() {
		return cabecalho() + corpo() + conclusao();
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
