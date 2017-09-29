package ex1;

class CartaComercial extends Carta {
	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Endereco _enderecoRemetente;
	private Endereco _enderecoDestinatario;
	private Data _data;
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data) {
		this._remetente = remetente;
		this._destinatario = destinatario;
		this._enderecoRemetente = remetente.getEndereco();
		this._enderecoDestinatario = destinatario.getEndereco();
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
	protected String cabecarioPortuges(String assunto) {
		return _remetente.getNomeEmpresa() + "\n"
				+ _remetente.getDepartamento() + "\n"
				+ _enderecoRemetente.toString() + ", "+_data.toString() + "\n"
				+ "Assunto: " + assunto + "\n\n";
	}
	
	protected String corpo() {
		return "Dear "+ _destinatario.getNome() + "\n" ;
	}
	protected String corpoPortugues(String vocativo, String mensagem) {
		return vocativo + _destinatario.getNome()+": " +"\n\n"
				+ mensagem +"\n\n";
	}
	protected String conclusao() {
		return "\nSincerely,\n";
	}
	protected String despedida(String despedida){
		return despedida +",\n\n" + _remetente.getNome()+"\n\n"
				+_remetente.getDepartamento();
	}
	protected String assinatura() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getFone()
				+ "\n            email:" + _remetente.getEmail();
	}
	
	

}
