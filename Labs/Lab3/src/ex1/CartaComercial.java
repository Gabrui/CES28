package ex1;

class CartaComercial {
	
	CartaComercial(Pessoa remetente, Pessoa destinatario, 
			Endereco enderecoRemetente, Endereco enderecoDestinatario, Data data) {
		// armazena todos os dados necessarios 
	}
	
	public String modelo() {
		return cabecario() + corpo() + conclusao() + assinatura();
	}
	
	protected String cabecario() {
		return date.toPrint() + "\n\n" + sender.name() + "\n" +
				addressSender.toPrint() + "\n" + destinatary.name() +
				addressDestiny.toPrint() + "\n";
	}
	
	protected String corpo() {
		return "Dear "+destinatary_.name() + "\n" ;
	}
	
	protected String conclusao() {
		return "\nSincerely,\n";
	}
	
	protected String assinatura() {
		return "\n\n            __________________\n            "+ sender_.name() + "\n            " + sender.phone().toPrint() +       "\n            email:" + sender.email();
		//espaços representam justificação à direita.keep it simple!
	}

}
