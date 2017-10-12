package ex2;

/**
 * 
 * Classe que representa o formato de uma Carta Comercial.
 *
 */
class CartaComercial extends Carta {
	
	public CartaComercial(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		super(remetente, destinatario, data, idioma);
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
				+ "\n            "+ _remetente.getFone(_idioma)
				+ "\n            email:" + _remetente.getEmail();
	}
	
	
	

}
