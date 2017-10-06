package ex1;

class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data) {
		super(remetente, destinatario, data);
		setVocativo("Prezado senhor");
	}
	
	@Override
	public String modelo() {
		return super.modelo() + informacoes();
	}
	
	@Override
	protected String cabecalho() {
		return _remetente.getNomeEmpresa() + "\n" + super.cabecalho();
	}
	
	protected String informacoes() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getEmprego()
				+ "\n            "+ _remetente.getFone()
				+ "\n            email:" + _remetente.getEmail();
	}
	

}
