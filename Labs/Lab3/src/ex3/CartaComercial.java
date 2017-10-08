package ex3;

class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		super(remetente, destinatario, data, idioma);
	}
	public String modelo(String assunto, String mensagem) {
		if(_idioma instanceof Ingles) {
			return modeloIngles(mensagem);
		}
		else if(_idioma instanceof Portugues) {
			return modeloPortugues(assunto, mensagem);
		}
		else {
			return "Idioma inexistente na Carta.";
		}
	}
	
	private String modeloPortugues(String assunto,String mensagem) {
		return cabecarioPortugues(assunto) + corpo(mensagem) + despedida() + assinaturaPortugues();
	}
	private String modeloIngles(String mensagem) {
		return cabecalhoIngles() + corpo(mensagem) + despedida() + assinaturaIngles();
	}
	protected String cabecalhoIngles() {
		return _data.toString() + "\n\n" + _remetente.getNome() + "\n" +
				_remetente.getEndereco(_idioma) + "\n" + _destinatario.getNome() + "\n" +
				_destinatario.getEndereco(_idioma) + "\n\n\n";
	}
	
	protected String cabecarioPortugues(String assunto) {
		return _remetente.getNomeEmpresa() + "\n"
				+ _remetente.getDepartamento() + "\n"
				+ _remetente.getEndereco(_idioma) + ", "
				+ _idioma.data(_data)
				+ "\n"
				+ "Assunto: " + assunto + "\n\n";
	}
	
	protected String corpo(String mensagem) {
		return _idioma.vocativo() + _destinatario.getNome()+": " +"\n\n"
				+ mensagem +"\n\n";
	}
	protected String despedida(){
		return _idioma.despedida() +",\n\n";
	}
	protected String assinaturaIngles() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getFone(_idioma)
				+ "\n            email:" + _remetente.getEmail();
	}
	protected String assinaturaPortugues() {
		return  _remetente.getNome() + "\n\n"
				+_remetente.getDepartamento();
	}
	

}
