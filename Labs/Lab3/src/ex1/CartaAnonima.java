package ex1;

public class CartaAnonima extends Carta {

	public CartaAnonima(Pessoa destinatario, Data data) {
		super(new Pessoa.PessoaBuilder().build(), destinatario, data);
	}
	
	@Override
	public String modelo() {
		return cabecalho() + corpo() + conclusao();
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
