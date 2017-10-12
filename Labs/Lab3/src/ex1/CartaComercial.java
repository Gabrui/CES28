package ex1;

/**
 * 
 * Classe que representa o formato de uma Carta Comercial.
 *
 */
class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data) {
		super(remetente, destinatario, data);
		setVocativo("Prezado senhor");
	}
	
	@Override
	public String assinatura() {
		return super.assinatura() + informacoesFinais();
	}
	
	@Override
	protected String cabecalho() {
		return _remetente.getNomeEmpresa() + "\n" + super.cabecalho();
	}
	
	protected String informacoesFinais() {
		return "\n\n            __________________\n            "
				+ _remetente.getNome() + "\n            " + _remetente.getEmprego()
				+ "\n            "+ _remetente.getFone()
				+ "\n            email:" + _remetente.getEmail();
	}
	

}
