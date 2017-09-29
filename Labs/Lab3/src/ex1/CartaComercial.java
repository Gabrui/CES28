package ex1;

class CartaComercial extends Carta {
	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Endereco _enderecoRemetente;
	private Endereco _enderecoDestinatario;
	private Data _data;
	
	/*public CartaComercial(Pessoa remetente, Pessoa destinatario, 
			Endereco enderecoRemetente, Endereco enderecoDestinatario, Data data) {
		this._remetente = remetente;
		this._destinatario = destinatario;
		this._enderecoRemetente = enderecoRemetente;
		this._enderecoDestinatario = enderecoDestinatario;
		this._data = data;
	}
	
	public String modelo() {
		return cabecario() + corpo() + conclusao() + assinatura();
	}
	
	protected String cabecario() {
		return _data.toString() + "\n\n" + _remetente.getNome() + "\n" +
				_enderecoRemetente.toString() + "\n" + _destinatario.getNome() +
				_enderecoDestinatario.toString() + "\n";
	}
	
	protected String corpo() {
		return "Dear "+ _destinatario.getNome() + "\n" ;
	}
	
	protected String conclusao() {
		return "\nSincerely,\n";
	}
	
	protected String assinatura() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getFone()
				+ "\n            email:" + _remetente.getEmail();
	}*/
	
	public String getconteudo() {
		return _cabecario + _corpo +_conclusao + _assinatura;
	}

}
