package ex2;

class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data) {
		super(remetente, destinatario, data);
	}
	
	public String modeloPortugues(String assunto,String vocativo,String mensagem,String despedida) {
		return cabecarioPortugues(assunto) + corpoPortugues(vocativo,mensagem) + despedida(despedida) + assinaturaPortugues();
	}
	
	protected String cabecalho() {
		return _data.toString() + "\n\n" + _remetente.getNome() + "\n" +
				_remetente.getEndereco() + "\n" + _destinatario.getNome() + "\n" +
				_destinatario.getEndereco() + "\n\n\n";
	}
	
	protected String cabecarioPortugues(String assunto) {
		return _remetente.getNomeEmpresa() + "\n"
				+ _remetente.getDepartamento() + "\n"
				+ _remetente.getEndereco() + ", "+_data.getDataPortugues(" de ") + "\n"
				+ "Assunto: " + assunto + "\n\n";
	}
	
	protected String corpo() {
		return "Dear "+ _destinatario.getNome() + ",\n" ;
	}
	protected String corpoPortugues(String vocativo, String mensagem) {
		return vocativo + _destinatario.getNome()+": " +"\n\n"
				+ mensagem +"\n\n";
	}
	protected String conclusao() {
		return "\nSincerely,\n";
	}
	protected String despedida(String despedida){
		return despedida +",\n\n";
	}
	protected String assinatura() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getFone()
				+ "\n            email:" + _remetente.getEmail();
	}
	protected String assinaturaPortugues() {
		return  _remetente.getNome() + "\n\n"
				+_remetente.getDepartamento();
	}
	

}
